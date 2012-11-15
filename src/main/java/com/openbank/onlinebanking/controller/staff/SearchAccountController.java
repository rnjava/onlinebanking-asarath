package com.openbank.onlinebanking.controller.staff;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.openbank.onlinebanking.blo.AccountService;
import com.openbank.onlinebanking.blo.ProfileService;
import com.openbank.onlinebanking.dto.Account;
import com.openbank.onlinebanking.dto.Profile;
import com.openbank.onlinebanking.form.staff.CustomerSearchForm;
import com.openbank.onlinebanking.form.staff.SearchResultForm;

@Controller
public class SearchAccountController {

	private AccountService accountService;
	private ProfileService profileService;
	private static Logger log = LoggerFactory.getLogger(SearchAccountController.class);
	
	@RequestMapping(value="/searchaccount",  headers = "content-type=application/x-www-form-urlencoded", method=RequestMethod.POST)
	public ModelAndView getAccountDetails(@ModelAttribute SearchResultForm searchResultForm) {

		log.debug("Entering - SearchResultForm : {}", searchResultForm.toString());
		Account account = null;
		ModelAndView modelAndView = new ModelAndView("staffloginsuccess");
		if(searchResultForm.getAccountNo() != null) {
			account = accountService.getAccountByAccountNo(searchResultForm.getAccountNo(), searchResultForm.getTenantId());
			if(account != null ) {
				log.debug("Account found {}", account.toString());
				Profile profile = profileService.getProfileById(account.getProfileId(), searchResultForm.getTenantId());
				searchResultForm.setUserProfileId(profile.getProfileId());
				searchResultForm.setUserFirstName(profile.getFirstName());
				searchResultForm.setUserLastName(profile.getLastName());
				modelAndView = new ModelAndView("searchsuccess");
				

			} else {
				log.debug("Account not found");
				modelAndView.addObject("errorMessage", "Customer not found");
			}

		} else {
			modelAndView.addObject("errorMessage", "Please enter the account number");
		}
			
		
		modelAndView.addObject("form", searchResultForm);
		log.debug("Existing..........");
		return modelAndView;
	}
	
	
	@RequestMapping(value="/staffloginsuccess",  method=RequestMethod.GET)
	public ModelAndView loadStaffLoginSuccess(@RequestParam(value = "profileid") String profileId, @RequestParam (value = "tenantid") String tenantId ) {
		log.debug("Entering : (Profileid:{}, TenantId: {})", new Object[]{profileId, tenantId});
		ModelAndView modelAndView = null;
		modelAndView = new ModelAndView("staffloginsuccess");

		CustomerSearchForm customerSearchForm = new CustomerSearchForm();
		customerSearchForm.setTenantId(tenantId);
		Profile profile = profileService.getProfileById(profileId, tenantId);
		if(profile != null) {
			customerSearchForm.setStaffProfileId(profile.getProfileId());
			customerSearchForm.setStaffFirstName(profile.getFirstName());
			customerSearchForm.setStaffLastName(profile.getLastName());
		}
		modelAndView.addObject("form", customerSearchForm);
		log.debug("Existing..........");
		return modelAndView;
	}

	/**
	 * @param accountService the accountService to set
	 */
	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}

	/**
	 * @param profileService the profileService to set
	 */
	public void setProfileService(ProfileService profileService) {
		this.profileService = profileService;
	}
	
	
	
}
