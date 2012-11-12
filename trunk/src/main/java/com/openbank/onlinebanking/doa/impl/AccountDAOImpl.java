package com.openbank.onlinebanking.doa.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Order;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.openbank.onlinebanking.doa.AccountDAO;
import com.openbank.onlinebanking.doa.BaseDAO;
import com.openbank.onlinebanking.dto.Account;
import com.openbank.onlinebanking.dto.Transaction;

public class AccountDAOImpl extends BaseDAO implements AccountDAO  {
	
	private static Logger log = LoggerFactory.getLogger(AccountDAOImpl.class);
	
	private Query query = null;
	
	private static final String ACCOUNT_COLLECTION_NAME = "account";
	private static final String TRANSACTION_COLLECTION_NAME = "transaction";
	
	public List<Account> getAccountsByProfileId(String profileId, String tenantId) {
			
			query = new Query(Criteria.where("profileId").is(profileId)
					.and("tenantId").is(tenantId));
			log.debug("Query : " + query);
			List<Account> accountList = mongoTemplate.find(query, Account.class, ACCOUNT_COLLECTION_NAME);
			return accountList;
	}

	public List<Transaction> getTransactionByAccountId(String accountId, String tenantId) {
		query = new Query(Criteria.where("accountNo").is(accountId)
				.and("tenantId").is(tenantId));
		log.debug("Query : " + query);
		List<Transaction> transactionList = mongoTemplate.find(query, Transaction.class, TRANSACTION_COLLECTION_NAME);
		return transactionList;
	}

	public Account getAccountByAccountNo(String accountNo, String tenantId) {
		query = new Query(Criteria.where("accountNo").is(accountNo)
				.and("tenantId").is(tenantId));
		log.debug("Query : " + query);
		Account account = mongoTemplate.findOne(query, Account.class, ACCOUNT_COLLECTION_NAME);
		return account;
	}

	@SuppressWarnings("deprecation")
	public String getMaxAccountNo(String tenantId) {
		
		String accountNo = null;
		query = new Query(Criteria.where("tenantId").is(tenantId));
		query.sort().on("accountNo", Order.DESCENDING);
		query.limit(1);
		
		log.debug("Query : " + query);
		Account account = mongoTemplate.findOne(query, Account.class, ACCOUNT_COLLECTION_NAME);
		if (account != null) {
			accountNo = account.getAccountNo();
		}
		return accountNo;	
	}
	
	public void saveTransaction(Transaction transaction) {
		mongoTemplate.save(transaction, TRANSACTION_COLLECTION_NAME);
	}

	public void updateAccount(Account account) {
		query = new Query(Criteria.where("_id").is(account.getId()));
		log.debug("Query : " + query);
		mongoTemplate.updateFirst(query, new Update().set("balance", account.getBalance()), ACCOUNT_COLLECTION_NAME);
	}
	
	public void saveAccount(Account account) {
		log.debug("Entering .........");
		mongoTemplate.save(account, ACCOUNT_COLLECTION_NAME);
	}
}
