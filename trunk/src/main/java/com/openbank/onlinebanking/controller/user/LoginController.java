package com.openbank.onlinebanking.controller.user;

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
	public ModelAndView processForm(@Valid LoginForm loginForm, BindingResult result) {
			
			ModelAndView modelAndView = null;
			User user = loginService.login(loginForm.getUserName(), loginForm.getTenantId(), loginForm.getPassword());
			
			//log.debug("ProfileId for userId [{}] is [{}]", loginForm.getUserName(), profileId);
			
			if (user != null && user.getProfileId() != null) {
				modelAndView = accountController.getAccountOverview(user.getProfileId(), loginForm.getTenantId()); 
			} else {
				modelAndView = new ModelAndView("login");
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
	 * @param accountController the accountController to set
	 */
	public void setAccountController(AccountController accountController) {
		this.accountController = accountController;
	}

	
}