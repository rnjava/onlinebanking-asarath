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
import com.openbank.onlinebanking.form.LoginForm;

@Controller
//@SessionAttributes
@RequestMapping("/stafflogin")
public class StaffLoginController {
	
	private static Logger log = LoggerFactory.getLogger(StaffLoginController.class);
	
	private LoginService loginService;
		
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
			String profileId = loginService.login(loginForm.getUserName(), loginForm.getTenantId(), loginForm.getPassword());
			
			log.debug("ProfileId for userId [{}] is [{}]", loginForm.getUserName(), profileId);
			
			if (profileId != null) {
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

}