package com.openbank.onlinebanking.blo.impl;

import java.util.List;

import com.openbank.onlinebanking.blo.AccountService;
import com.openbank.onlinebanking.doa.AccountDAO;
import com.openbank.onlinebanking.dto.Account;
import com.openbank.onlinebanking.dto.Transaction;

public class AccountServiceImpl implements AccountService {
	
	private AccountDAO accountDAO;

	public List<Account> getAccountsByProfileId(String profileId, String tenantId) {
		List<Account> accountList= accountDAO.getAccountsByProfileId(profileId, tenantId);
		return accountList;
	}
	
	
	public List<Transaction> getTransactionByAccountId(String accountId, String tenantId) {
		List<Transaction> transactionList = accountDAO.getTransactionByAccountId(accountId, tenantId);
		return transactionList;
	}

	/**
	 * @param accountDAO the accountDAO to set
	 */
	public void setAccountDAO(AccountDAO accountDAO) {
		this.accountDAO = accountDAO;
	}


	public Account getAccountByAccountNo(String accountNo, String tenantId) {
		return accountDAO.getAccountByAccountNo(accountNo, tenantId);
	}
	
	
	
}
