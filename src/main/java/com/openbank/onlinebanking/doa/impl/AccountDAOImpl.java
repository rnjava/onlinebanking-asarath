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
	
	public List<Account> getAccountsByProfileId(String profileId, String tenantId) {
			
			query = new Query(Criteria.where("profileId").is(profileId)
					.and("tenantId").is(tenantId));
			List<Account> accountList = mongoTemplate.find(query, Account.class, "account");
			return accountList;
	}

	public List<Transaction> getTransactionByAccountId(String accountId, String tenantId) {
		query = new Query(Criteria.where("accountNo").is(accountId)
				.and("tenantId").is(tenantId));
		List<Transaction> transactionList = mongoTemplate.find(query, Transaction.class, "transaction");
		return transactionList;
	}

	public Account getAccountByAccountNo(String accountNo, String tenantId) {
		query = new Query(Criteria.where("accountNo").is(accountNo)
				.and("tenantId").is(tenantId));
		Account account = mongoTemplate.findOne(query, Account.class, "account");
		System.out.println(query);
		return account;

	}

}
