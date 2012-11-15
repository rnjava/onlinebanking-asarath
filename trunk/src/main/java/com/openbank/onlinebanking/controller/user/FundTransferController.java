package com.openbank.onlinebanking.controller.user;

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

import com.openbank.onlinebanking.blo.AccountService;
import com.openbank.onlinebanking.blo.FundTransferService;
import com.openbank.onlinebanking.blo.ProfileService;
import com.openbank.onlinebanking.dto.Account;
import com.openbank.onlinebanking.dto.FundRecipient;
import com.openbank.onlinebanking.dto.Profile;
import com.openbank.onlinebanking.form.TransferForm;

@Controller
//@RequestMapping("/user")
public class FundTransferController {
	
	private static Logger log = LoggerFactory.getLogger(FundTransferController.class);
	
	private FundTransferService fundTransferService;
	private AccountService accountService;
	private ProfileService profileService;
	
	@RequestMapping(value="/maketransfer", method=RequestMethod.GET)
	public ModelAndView makeTransfer(@RequestParam(value = "profileid") String profileId, 
			@RequestParam (value = "tenantid") String tenantId) {
		log.debug("Entering.....");
		TransferForm form = new TransferForm();
		form.setTenantId(tenantId);
		form.setProfileId(profileId);
		ModelAndView modelAndView = new ModelAndView("maketransfer");
		modelAndView.addObject("form", form);
		log.debug("Exiting.....");
		return modelAndView;
	}

	@RequestMapping(value="/addrecipient", method=RequestMethod.GET)
	public ModelAndView addRecipient(@RequestParam(value = "profileid") String profileId, 
			@RequestParam (value = "tenantid") String tenantId) {
		log.debug("Entering.....");				
		TransferForm form = new TransferForm();
		form.setTenantId(tenantId);
		form.setProfileId(profileId);
		ModelAndView modelAndView = new ModelAndView("addrecipient");
		modelAndView.addObject("form", form);
		log.debug("Exiting.....");
		return modelAndView;
	}
	
	
	@RequestMapping(value="/addNewRecipient", method=RequestMethod.POST)
	public ModelAndView addNewRecipient(TransferForm form,  BindingResult result) {
		log.debug("Entering.....");
		ModelAndView modelAndView = new ModelAndView("addrecipient");
		validate(form, result);
		if(!result.hasErrors()) {
			Account account = accountService.getAccountByAccountNo(form.getRecipientAccountNo(), form.getTenantId());
			if(account != null) {
				Profile profile = profileService.getProfileById(account.getProfileId(), form.getTenantId());
				if(form.getLastName().equalsIgnoreCase(profile.getLastName())) {
					FundRecipient fundRecipient = new FundRecipient();
					fundRecipient.setLastName(form.getLastName());
					fundRecipient.setNickName(form.getNickName());
					fundRecipient.setProfileId(form.getProfileId());
					fundRecipient.setRecipientAccountNo(form.getRecipientAccountNo());
					fundRecipient.setTenantId(form.getTenantId());
					
					fundTransferService.createFundRecipient(fundRecipient);
					modelAndView.addObject("successMessage", "Recipient Added Successfully!!!");
					
				} else {
					log.debug("Last Name doesn't match");
					result.addError(new ObjectError("profile", "Last name and account no doesn't match"));
				}
			} else {
				log.debug("The account No not found");
				result.addError(new ObjectError("accountNo", "Account Number doesn't exists"));
			}
		}

		resetTransferForm(form);
		modelAndView.addObject("form", form);
		log.debug("Exiting.....");
		return modelAndView;
	}

	private void resetTransferForm(TransferForm form) {
		form.setLastName(null);
		form.setNickName(null);
		form.setRecipientAccountNo(null);
		
	}
	
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "","LastName cannot be blank");
	    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "recipientAccountNo", "", "Account number cannot be blank");
	}


	/**
	 * @param fundTransferService the fundTransferService to set
	 */
	public void setFundTransferService(FundTransferService fundTransferService) {
		this.fundTransferService = fundTransferService;
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
