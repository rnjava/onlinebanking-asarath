package com.openbank.onlinebanking.blo;

import java.util.List;

import com.openbank.onlinebanking.dto.Account;
import com.openbank.onlinebanking.dto.Transaction;

public interface AccountService {

	List<Account> getAccountsByProfileId(String profileId, String tenantId);

	List<Transaction> getTransactionByAccountId(String accountId, String tenantId);
	
	Account getAccountByAccountNo(String accountNo, String tenantId);
	
	String saveAccount(Account account);

}
