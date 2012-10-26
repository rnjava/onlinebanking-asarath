package com.openbank.onlinebanking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.openbank.onlinebanking.blo.AccountService;
import com.openbank.onlinebanking.blo.ProfileService;
import com.openbank.onlinebanking.form.AccountDetailsForm;
import com.openbank.onlinebanking.form.AccountOverviewForm;

@Controller
public class AccountController {
	
	private ProfileService profileService;
	private AccountService accountService;

	@RequestMapping(value="/accountsoverview", method=RequestMethod.GET)
	public ModelAndView getAccountOverview(@RequestParam(value = "profileid") String profileId, 
			@RequestParam (value = "tenantid") String tenantId) {
				AccountOverviewForm form = new AccountOverviewForm();
				form.setTenantId(tenantId);
				form.setProfile(profileService.getProfileById(profileId, tenantId));
				form.setAccountList(accountService.getAccountsByProfileId(profileId, tenantId));
				form.setFirstAccountId(form.getAccountList().get(0).getId());
				
				ModelAndView modelAndView = new ModelAndView("accountsoverview");
				modelAndView.addObject("form", form);
				return modelAndView;
		}
	
	@RequestMapping(value="/accountdetails", method=RequestMethod.GET)
	public ModelAndView getAccountDetails(@RequestParam(value = "accountid") String accountId, 
			@RequestParam (value = "tenantid") String tenantId, @RequestParam(value = "profileid") String profileId ) {
				AccountDetailsForm form = new AccountDetailsForm();
				
				form.setTenantId(tenantId);
				form.setProfileId(profileId);
				form.setAccountId(accountId);
				form.setTransactionList(accountService.getTransactionByAccountId(accountId, tenantId));
				ModelAndView modelAndView = new ModelAndView("accountdetails");
				modelAndView.addObject("form", form);
				return modelAndView;
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