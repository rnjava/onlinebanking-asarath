package com.openbank.onlinebanking.controller.staff;

import org.springframework.stereotype.Controller;
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
	
	@RequestMapping(value="/searchaccount",  headers = "content-type=application/x-www-form-urlencoded", method=RequestMethod.POST)
	public ModelAndView getAccountDtails(@ModelAttribute SearchResultForm searchResultForm ) {
				
				Account account = accountService.getAccountByAccountNo(searchResultForm.getAccountNo(), searchResultForm.getTenantId());
				if(account != null ) {
					Profile profile = profileService.getProfileById(account.getProfileId(), searchResultForm.getTenantId());
					searchResultForm.setUserProfileId(profile.getProfileId());
					searchResultForm.setUserFirstName(profile.getFirstName());
					searchResultForm.setUserLastName(profile.getLastName());
				} else {
					
				}
			
				ModelAndView modelAndView = new ModelAndView("searchsuccess");
				modelAndView.addObject("form", searchResultForm);
				return modelAndView;
		}
	
	
	@RequestMapping(value="/staffloginsuccess",  method=RequestMethod.GET)
	public ModelAndView getStaffLogin(@RequestParam(value = "profileid") String profileId, @RequestParam (value = "tenantid") String tenantId ) {
				
				ModelAndView modelAndView = null;
				modelAndView = new ModelAndView("staffloginsuccess");

				CustomerSearchForm customerSearchForm = new CustomerSearchForm();
				customerSearchForm.setTenantId(tenantId);
				Profile profile = profileService.getProfileById(profileId, tenantId);
				if(profile != null) {
					customerSearchForm.setProfileId(profile.getProfileId());
					customerSearchForm.setFirstName(profile.getFirstName());
					customerSearchForm.setLastName(profile.getLastName());
				}
				modelAndView.addObject("form", customerSearchForm);
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
