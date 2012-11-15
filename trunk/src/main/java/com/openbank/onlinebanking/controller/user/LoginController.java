package com.openbank.onlinebanking.controller.user;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.validation.ValidationUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.openbank.onlinebanking.blo.LoginService;
import com.openbank.onlinebanking.dto.User;
import com.openbank.onlinebanking.form.LoginForm;

@Controller
//@SessionAttributes
@RequestMapping("/login")
public class LoginController {
	
	private static Logger log = LoggerFactory.getLogger(LoginController.class);
	
	private LoginService loginService;
	private AccountController accountController; 
//	private ProfileService profileService;
//	private AccountService accountService;
		
	@RequestMapping(method = RequestMethod.GET )
	public String showForm(Map<String, LoginForm> model, @RequestParam(value = "tenantid") String tenantId) {
			LoginForm loginForm = new LoginForm();
			loginForm.setTenantId(tenantId);
			model.put("loginForm", loginForm);
			return "login";
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView processForm(LoginForm loginForm, BindingResult result) {
		ModelAndView modelAndView = null;
		boolean isSuccess = false;
		validate(loginForm, result);	
		if (!result.hasErrors()) {
			User user = loginService.login(loginForm.getUserName(), loginForm.getTenantId(), loginForm.getPassword());
			if (user != null && user.getProfileId() != null) {
				if("CUSTOMER".equals(user.getRole().getPrimary())) {
					modelAndView = accountController.getAccountOverview(user.getProfileId(), loginForm.getTenantId());
					isSuccess = true;
				} else {
					log.debug("The user don't have a CUSTOMER ROLE");
					result.addError(new ObjectError("role", "You are not authorized to login"));
	
				}
			} else {
				result.addError(new ObjectError("password", "Username or Password is wrong"));
			}
		}
		if(!isSuccess) {
			modelAndView = new ModelAndView("login");
			//loginForm = new LoginForm();
			loginForm.setPassword(null);
			loginForm.setUserName(null);
			modelAndView.addObject("form", loginForm);
		}
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
	 * @param accountController the accountController to set
	 */
	public void setAccountController(AccountController accountController) {
		this.accountController = accountController;
	}

	
}