package com.openbank.onlinebanking.controller.staff;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
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
		modelAndView.addObject("form", depositForm);
		log.debug("Existing..........");
		return modelAndView;
	}

	
	//staffdepositsubmit
	
	@RequestMapping(value="/staffdepositsubmit",  method=RequestMethod.POST)
	public ModelAndView depositFormSubmit(@ModelAttribute DepositForm depositForm ) {
		
		log.debug("Entering - depositFormSubmit : {}", depositForm.toString());
		ModelAndView modelAndView = new ModelAndView("staffdeposit");
		
		Account account = accountService.getAccountByAccountNo(depositForm.getAccountNo(), depositForm.getTenantId());
		
		Transaction transaction = createTransaction(depositForm);
		double newBalance = account.getBalance() + depositForm.getAmount();
		transaction.setAvailableBalance(newBalance);
		
		accountService.saveTransaction(transaction);
		account.setBalance(newBalance);
		accountService.updateAccount(account);
		
		
		modelAndView.addObject("successMessage", "Transfer Success. New Availabe balance is "+newBalance+ "!!!");
		//resetForm(createAccountForm);
		modelAndView.addObject("form", depositForm);
		log.debug("Exiting..........");
		return modelAndView;

	}	
	
	private Transaction createTransaction(DepositForm depositForm) {
		Transaction transaction = new Transaction();
		transaction.setAccountNo(depositForm.getAccountNo());
		transaction.setAmount(depositForm.getAmount());
		transaction.setType("CR");
		transaction.setMode(depositForm.getMode());
		transaction.setDate(new Date());
		transaction.setStatus("Processed");
		return transaction;
		
	}


	@RequestMapping(value="/staffwithdrawal",  method=RequestMethod.GET)
	public ModelAndView loadWithDrawalForm(@RequestParam(value = "tenantid") String tenantId, 
			@RequestParam(value = "profileid") String profileId, 
			@RequestParam(value = "accountno") String accountNo) {

		log.debug("Entering....");
		DepositForm depositForm = new DepositForm();
		depositForm.setTenantId(tenantId);
		depositForm.setStaffProfileId(profileId);
		ModelAndView modelAndView = new ModelAndView("staffwithdrawal");
		modelAndView.addObject("form", depositForm);
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
	 * @param searchAccountController the searchAccountController to set
	 */
	public void setSearchAccountController(
			SearchAccountController searchAccountController) {
		this.searchAccountController = searchAccountController;
	}
	
	
	
}
