package com.openbank.onlinebanking.controller.admin;

import static com.openbank.onlinebanking.util.ApplicationConstants.TENANT_ADMIN_ROLE;

import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.validation.ValidationUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.openbank.onlinebanking.blo.LoginService;
import com.openbank.onlinebanking.blo.ProfileService;
import com.openbank.onlinebanking.dto.Profile;
import com.openbank.onlinebanking.dto.User;
import com.openbank.onlinebanking.form.LoginForm;
import com.openbank.onlinebanking.form.admin.AdministrationForm;

@Controller
//@SessionAttributes
@RequestMapping("/adminlogin")
public class AdminLoginController {
	
	private static Logger log = LoggerFactory.getLogger(AdminLoginController.class);
	
	private LoginService loginService;
	private ProfileService profileService;
		
	@RequestMapping(method = RequestMethod.GET )
	public String showForm(Map<String, LoginForm> model) {
		log.debug("Entering");
		LoginForm loginForm = new LoginForm();
		//loginForm.setTenantId(tenantId);
		model.put("loginForm", loginForm);
		log.debug("Exiting");
		return "adminlogin";
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView processForm(LoginForm loginForm, BindingResult result) {
		loginForm.setTenantId("039E8ED1-313A-412B-9ED4-DEE675FF544A");
		log.debug("Entering");	
		ModelAndView modelAndView = null;
		boolean isSuccess = false;
		validate(loginForm, result);	
		if (!result.hasErrors()) {
			User user = loginService.login(loginForm.getUserName(), loginForm.getTenantId(), loginForm.getPassword());
			if (user != null && user.getProfileId() != null) {
				if(TENANT_ADMIN_ROLE.equalsIgnoreCase(user.getRole().getPrimary())) {
					log.debug("User is a TENAT ADMIN - {}", user.toString());
					modelAndView = new ModelAndView("adminloginsuccess");
					AdministrationForm administrationForm = new AdministrationForm();
					administrationForm.setTenantId(loginForm.getTenantId());
					Profile profile = profileService.getProfileById(user.getProfileId(), loginForm.getTenantId());
					if(profile != null) {
						administrationForm.setStaffProfileId(profile.getProfileId());
						administrationForm.setStaffFirstName(profile.getFirstName());
						administrationForm.setStaffLastName(profile.getLastName());
					}
					modelAndView.addObject("form", administrationForm);
					isSuccess = true;
				} else {
					log.debug("The user don't have a TEANNTADMIN ROLE");
					result.addError(new ObjectError("role", "You are not authorized to login"));
				}
			} else {
				log.debug("User not logged in");
				result.addError(new ObjectError("password", "Username or Password is wrong"));
			}
			
		}
		
		if(!isSuccess) {
			modelAndView = new ModelAndView("adminlogin");
			loginForm.setPassword(null);
			loginForm.setUserName(null);
			modelAndView.addObject("form", loginForm);
		}

		log.debug("Exiting");
		return modelAndView;
	}

	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "","Password cannot be blank");
	    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "", "User name cannot be blank");
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