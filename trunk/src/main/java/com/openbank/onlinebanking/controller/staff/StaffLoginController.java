package com.openbank.onlinebanking.controller.staff;

import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.openbank.onlinebanking.blo.LoginService;
import com.openbank.onlinebanking.blo.ProfileService;
import com.openbank.onlinebanking.dto.Profile;
import com.openbank.onlinebanking.dto.User;
import com.openbank.onlinebanking.form.LoginForm;
import com.openbank.onlinebanking.form.staff.CustomerSearchForm;

@Controller
//@SessionAttributes
@RequestMapping("/stafflogin")
public class StaffLoginController {
	
	private static Logger log = LoggerFactory.getLogger(StaffLoginController.class);
	
	private LoginService loginService;
	private ProfileService profileService;
		
	@RequestMapping(method = RequestMethod.GET )
	public String showForm(Map<String, LoginForm> model, @RequestParam(value = "tenantid") String tenantId) {
			LoginForm loginForm = new LoginForm();
			loginForm.setTenantId(tenantId);
			model.put("loginForm", loginForm);
			return "stafflogin";
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView processForm(@Valid LoginForm loginForm, BindingResult result) {
			
			ModelAndView modelAndView = null;
			User user = loginService.login(loginForm.getUserName(), loginForm.getTenantId(), loginForm.getPassword());
			
			//log.debug("ProfileId for userId [{}] is [{}]", loginForm.getUserName(), profileId);
			
			if (user != null && user.getProfileId() != null) {
				if("STAFF".equalsIgnoreCase(user.getRole().getPrimary())) {
					System.out.println("Correct userId");
					modelAndView = new ModelAndView("staffloginsuccess");
					CustomerSearchForm customerSearchForm = new CustomerSearchForm();
					customerSearchForm.setTenantId(loginForm.getTenantId());
					Profile profile = profileService.getProfileById(user.getProfileId(), loginForm.getTenantId());
					if(profile != null) {
						customerSearchForm.setProfileId(profile.getProfileId());
						customerSearchForm.setFirstName(profile.getFirstName());
						customerSearchForm.setLastName(profile.getLastName());
					}
					
					modelAndView.addObject("form", customerSearchForm);
					
				} else {
					System.out.println("Not a staff");
					modelAndView = new ModelAndView("stafflogin");
					loginForm = new LoginForm();
					modelAndView.addObject("form", loginForm);
				}
				
				//modelAndView = accountController.getAccountOverview(profileId, loginForm.getTenantId()); 
			} else {
				modelAndView = new ModelAndView("stafflogin");
				loginForm = new LoginForm();
				modelAndView.addObject("form", loginForm);
			}
			
			return modelAndView;
		}

	/**
	 * @param loginService the loginService to set
	 */
	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}

	/**
	 * @param profileService the profileService to set
	 */
	public void setProfileService(ProfileService profileService) {
		this.profileService = profileService;
	}

	
}