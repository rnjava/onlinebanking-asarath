package com.openbank.onlinebanking.controller;

import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.openbank.onlinebanking.blo.AccountService;
import com.openbank.onlinebanking.blo.LoginService;
import com.openbank.onlinebanking.blo.ProfileService;
import com.openbank.onlinebanking.form.AccountOverviewForm;
import com.openbank.onlinebanking.form.LoginForm;

@Controller
//@SessionAttributes
@RequestMapping("login")
public class LoginController {
	
	private static Logger log = LoggerFactory.getLogger(LoginController.class);
	
	private LoginService loginService;
	private ProfileService profileService;
	private AccountService accountService;
		
	@RequestMapping(method = RequestMethod.GET)
	public String showForm(Map<String, LoginForm> model) {
			LoginForm loginForm = new LoginForm();
			model.put("loginForm", loginForm);
			return "login";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String processForm(@Valid LoginForm loginForm, BindingResult result,
				Map<String, Object> model) {
			String forward = "login";
			//LoginService service = new LoginServiceImpl();
			String profileId = loginService.login(loginForm.getUserName(), loginForm.getTenantId(), loginForm.getPassword());
			
			log.debug("ProfileId for userId [{}] is [{}]", loginForm.getUserName(), profileId);
			
			if (profileId != null) {
				AccountOverviewForm form = new AccountOverviewForm();
				form.setProfile(profileService.getProfileById(profileId, loginForm.getTenantId()));
				form.setAccountList(accountService.getAccountsByProfileId(profileId, loginForm.getTenantId()));
				forward = "accountsoverview";
				model.put("accountOverviewForm", form);
			} else {
				loginForm = new LoginForm();
				model.put("loginForm", loginForm);
			}
			
			return forward;
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

	/**
	 * @param accountService the accountService to set
	 */
	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}



}