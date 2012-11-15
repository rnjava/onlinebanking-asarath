package com.openbank.onlinebanking.controller.staff;

import java.util.Date;
import java.util.LinkedHashMap;
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
import com.openbank.onlinebanking.dto.Account;
import com.openbank.onlinebanking.dto.Transaction;
import com.openbank.onlinebanking.form.staff.DepositForm;

@Controller
public class StaffTransactionController {
	
	private AccountService accountService;
	private SearchAccountController searchAccountController;
	
	private static Logger log = LoggerFactory.getLogger(StaffTransactionController.class);
	
	@RequestMapping(value="/staffdeposit",  method=RequestMethod.GET)
	public ModelAndView loadDepostForm(@RequestParam(value = "tenantid") String tenantId, 
			@RequestParam(value = "profileid") String profileId, 
			@RequestParam(value = "accountno") String accountNo) {

		log.debug("Entering....");
		DepositForm depositForm = new DepositForm();
		depositForm.setTenantId(tenantId);
		depositForm.setStaffProfileId(profileId);
		depositForm.setAccountNo(accountNo);
		ModelAndView modelAndView = new ModelAndView("staffdeposit");
		modelAndView.addObject("transModelist", loadModeMap());
		modelAndView.addObject("form", depositForm);
		log.debug("Existing..........");
		return modelAndView;
	}

	@RequestMapping(value="/staffdepositsubmit",  method=RequestMethod.POST)
	public ModelAndView depositFormSubmit(@ModelAttribute DepositForm depositForm, BindingResult result) {
		
		log.debug("Entering - depositFormSubmit : {}", depositForm.toString());
		ModelAndView modelAndView = new ModelAndView("staffdeposit");
		
		validate(depositForm, result);
		if(!result.hasErrors()) {
			Account account = accountService.getAccountByAccountNo(depositForm.getAccountNo(), depositForm.getTenantId());
			
			Transaction transaction = createTransaction(depositForm);
			double newBalance = account.getBalance() + depositForm.getAmount();
			transaction.setAvailableBalance(newBalance);
			
			accountService.saveTransaction(transaction);
			account.setBalance(newBalance);
			accountService.updateAccount(account);
			
			
			modelAndView.addObject("successMessage", "Transaction Successful. New Availabe balance is "+newBalance+ "!!!");
			resetForm(depositForm);
		}
		modelAndView.addObject("form", depositForm);
		modelAndView.addObject("transModelist", loadModeMap());
		log.debug("Exiting..........");
		return modelAndView;

	}	
	
	private void resetForm(DepositForm depositForm) {
		depositForm.setAmount(null);
		depositForm.setApprovalNeeded(false);
		depositForm.setMode(null);
	}

	private Transaction createTransaction(DepositForm depositForm) {
		Transaction transaction = new Transaction();
		transaction.setAccountNo(depositForm.getAccountNo());
		transaction.setAmount(depositForm.getAmount());
		transaction.setType("CR");
		transaction.setMode(depositForm.getMode());
		transaction.setDescription(depositForm.getDescription());
		transaction.setDate(new Date());
		transaction.setStatus("Processed");
		transaction.setTenantId(depositForm.getTenantId());
		return transaction;
		
	}

	public void validate(DepositForm target,BindingResult result) {
		if(target.getMode() == null || target.getMode().trim().isEmpty()) {
			result.addError(new ObjectError("mode", "Select the transaction mode"));
		}
		
		if(target.getAmount() == null || target.getAmount() < 1) {
			result.addError(new ObjectError("amount", "Enter valid amount"));
		}
	    
		if(target.getAmount() !=null && target.getAmount().isNaN()) {
	    	result.addError(new ObjectError("amount", "Invalid Amount"));
	    }
	    
	}
	
	private Map<String,String> loadModeMap() {
		Map<String,String> modeMap = new LinkedHashMap<String,String>();
			modeMap.put("CASH", "Cash");
			modeMap.put("CHEQUE", "Cheque");
			modeMap.put("DD", "Demant Draft");
		return modeMap;
	}
	
	@RequestMapping(value="/staffwithdrawal",  method=RequestMethod.GET)
	public ModelAndView loadWithDrawalForm(@RequestParam(value = "tenantid") String tenantId, 
			@RequestParam(value = "profileid") String profileId, 
			@RequestParam(value = "accountno") String accountNo) {

		log.debug("Entering....");
		DepositForm depositForm = new DepositForm();
		depositForm.setTenantId(tenantId);
		depositForm.setStaffProfileId(profileId);
		depositForm.setAccountNo(accountNo);
		ModelAndView modelAndView = new ModelAndView("staffwithdrawal");
		modelAndView.addObject("transModelist", loadModeMap());
		modelAndView.addObject("form", depositForm);
		log.debug("Existing..........");
		return modelAndView;
	}

	@RequestMapping(value="/staffwithdrawalsubmit",  method=RequestMethod.POST)
	public ModelAndView withdrawalFormSubmit(@ModelAttribute DepositForm depositForm, BindingResult result) {
		
		log.debug("Entering - depositFormSubmit : {}", depositForm.toString());
		ModelAndView modelAndView = new ModelAndView("staffwithdrawal");
		
		validate(depositForm, result);
		if(!result.hasErrors()) {
			Account account = accountService.getAccountByAccountNo(depositForm.getAccountNo(), depositForm.getTenantId());
			
			Transaction transaction = createTransaction(depositForm);
			double newBalance = account.getBalance() - depositForm.getAmount();
			if(newBalance < 0) {
				result.addError(new ObjectError("amount", "Don't have sufficient balance for this transaction"));
			} else {
				transaction.setAvailableBalance(newBalance);
				
				accountService.saveTransaction(transaction);
				account.setBalance(newBalance);
				accountService.updateAccount(account);
				
				
				modelAndView.addObject("successMessage", "Transaction Successful. New Availabe balance is "+newBalance+ "!!!");
				resetForm(depositForm);
			}	
		}
		modelAndView.addObject("form", depositForm);
		modelAndView.addObject("transModelist", loadModeMap());
		log.debug("Exiting..........");
		return modelAndView;

	}	

	
	/**
	 * @param accountService the accountService to set
	 */
	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}


	/**
	 * @param searchAccountController the searchAccountController to set
	 */
	public void setSearchAccountController(
			SearchAccountController searchAccountController) {
		this.searchAccountController = searchAccountController;
	}
	
	
	
}
