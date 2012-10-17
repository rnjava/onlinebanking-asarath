package com.openbank.onlinebanking.blo.impl;

import java.util.ArrayList;
import java.util.List;

import com.openbank.onlinebanking.blo.AccountService;
import com.openbank.onlinebanking.doa.AccountDAO;
import com.openbank.onlinebanking.dto.Account;

public class AccountServiceImpl implements AccountService {
	
	private AccountDAO accountDAO;

	@Override
	public List<Account> getAccountsByProfileId(String profileId, String tenantId) {
		List<Account> accountList= accountDAO.getAccountsByProfileId(profileId, tenantId);
		return accountList;
	}

	/**
	 * @param accountDAO the accountDAO to set
	 */
	public void setAccountDAO(AccountDAO accountDAO) {
		this.accountDAO = accountDAO;
	}
	
	
	
}
