package com.openbank.onlinebanking.doa.impl;

import java.util.List;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.openbank.onlinebanking.doa.AccountDAO;
import com.openbank.onlinebanking.doa.BaseDAO;
import com.openbank.onlinebanking.dto.Account;
import com.openbank.onlinebanking.dto.Transaction;

public class AccountDAOImpl extends BaseDAO implements AccountDAO  {
	
	private Query query = null;
	
	@Override
	public List<Account> getAccountsByProfileId(String profileId, String tenantId) {
			
			query = new Query(Criteria.where("profileId").is(profileId)
					.and("tenantId").is(tenantId));
			List<Account> accountList = mongoTemplate.find(query, Account.class, "account");
			return accountList;
	}

	@Override
	public List<Transaction> getTransactionByAccountId(String accountId, String tenantId) {
		query = new Query(Criteria.where("accountId").is(accountId)
				.and("tenantId").is(tenantId));
		List<Transaction> transactionList = mongoTemplate.find(query, Transaction.class, "transaction");
		return transactionList;
	}

}
