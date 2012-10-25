package com.openbank.onlinebanking.doa;

import java.util.List;

import com.openbank.onlinebanking.dto.Account;
import com.openbank.onlinebanking.dto.Transaction;

public interface AccountDAO {

	List<Account> getAccountsByProfileId(String profileId, String tenantId);

	List<Transaction> getTransactionByAccountId(String accountId, String tenantId);

}
