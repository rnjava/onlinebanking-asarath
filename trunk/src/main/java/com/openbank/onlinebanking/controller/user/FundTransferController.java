package com.openbank.onlinebanking.controller.user;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.validation.ValidationUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
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
import com.openbank.onlinebanking.dto.Transaction;
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
		List<Account> accountList = accountService.getAccountsByProfileId(profileId, tenantId);
		modelAndView.addObject("accountList", loadAccountMap(accountList));

		List<FundRecipient> recipientList = fundTransferService.getFundRecipient(profileId, tenantId);
		modelAndView.addObject("recipientList", loadRecipienttMap(recipientList));
		modelAndView.addObject("form", form);
		log.debug("Exiting.....");
		return modelAndView;
	}
	
	
	@RequestMapping(value="/submitTransfer", method=RequestMethod.POST)
	public ModelAndView submitTransfer(@ModelAttribute("form")TransferForm form,  BindingResult result) {
		log.debug("Entering.....");
		ModelAndView modelAndView = new ModelAndView("maketransfer");
		List<Account> accountList = accountService.getAccountsByProfileId(form.getProfileId(), form.getTenantId());
		modelAndView.addObject("accountList", loadAccountMap(accountList));

		validateFundTransfer(form, result);
	    if(form.getAmount() != null && form.getAmount() < 1) {
		    result.addError(new ObjectError("amount", "Please enter valid amount"));
	    }

		if(!result.hasErrors()) {
			
			Account transfeeAccount = accountService.getAccountByAccountNo(form.getAccountNo(), form.getTenantId());
			if(transfeeAccount.getBalance() < form.getAmount()) {
				
			} else {
				
				//Update Recipient
				Account recipientAccount = accountService.getAccountByAccountNo(form.getRecipientAccountNo(), form.getTenantId());
				
				Transaction transaction = createTransaction(form.getAmount(), "CR", form.getRecipientAccountNo(), "From:"+form.getAccountNo(), form.getTenantId());
				double newBalance = recipientAccount.getBalance() + form.getAmount();
				transaction.setAvailableBalance(newBalance);
				
				accountService.saveTransaction(transaction);
				recipientAccount.setBalance(newBalance);
				accountService.updateAccount(recipientAccount);
				
				//Update Transfeee
				transaction = createTransaction(form.getAmount(), "DR",form.getAccountNo(), "To :" + form.getRecipientAccountNo(), form.getTenantId());
				newBalance = transfeeAccount.getBalance() - form.getAmount();
				transaction.setAvailableBalance(newBalance);
				accountService.saveTransaction(transaction);
				transfeeAccount.setBalance(newBalance);
				accountService.updateAccount(transfeeAccount);
	
				modelAndView.addObject("successMessage", "Transfer Successful. New Availabe balance is "+newBalance+ "!!!");
				resetTransferForm(form);
			}
		}

			
		List<FundRecipient> recipientList = fundTransferService.getFundRecipient(form.getProfileId(), form.getTenantId());
		modelAndView.addObject("recipientList", loadRecipienttMap(recipientList));
		modelAndView.addObject("form", form);
		log.debug("Exiting.....");
		return modelAndView;
	}

	
	private Transaction createTransaction(Double amount, String type, String accountNo, String descString, String tenantId) {
		Transaction transaction = new Transaction();
		transaction.setAccountNo(accountNo);
		transaction.setAmount(amount);
		transaction.setType(type);
		transaction.setMode("Online Transfer");
		transaction.setDescription(descString);
		transaction.setDate(new Date());
		transaction.setStatus("Processed");
		transaction.setTenantId(tenantId);
		return transaction;
		
	}	

	private void validateFundTransfer(TransferForm form, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "accountNo", "","From Account cannot be blank");
	    //ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nickName", "", "Nick Name cannot be blank");
	    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "recipientAccountNo", "", "Recipient Nick Name cannot be blank");
	    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "amount", "", "Amount cannot be blank");
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
	public ModelAndView addNewRecipient(@ModelAttribute("form")TransferForm form,  BindingResult result) {
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
					resetTransferForm(form);

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

		modelAndView.addObject("form", form);
		log.debug("Exiting.....");
		return modelAndView;
	}
	
	private Map<String,String> loadAccountMap(List<Account> accountList) {
		Map<String,String> modeMap = new LinkedHashMap<String,String>();
		 for(Account account : accountList) {
				modeMap.put(account.getAccountNo(), account.getType());
		 }
		return modeMap;
	}		

	private Object loadRecipienttMap(List<FundRecipient> recipientList) {
		Map<String,String> modeMap = new LinkedHashMap<String,String>();
		 for(FundRecipient recipient : recipientList) {
				modeMap.put(recipient.getRecipientAccountNo(), recipient.getNickName());
		 }
		return modeMap;
	}
	
	
	private void resetTransferForm(TransferForm form) {
		form.setLastName(null);
		form.setNickName(null);
		form.setRecipientAccountNo(null);
		form.setAmount(null);
		
	}
	
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "","LastName cannot be blank");
	    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nickName", "", "Nick Name cannot be blank");
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
