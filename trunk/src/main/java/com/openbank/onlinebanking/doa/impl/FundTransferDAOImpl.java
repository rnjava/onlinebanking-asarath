package com.openbank.onlinebanking.doa.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.openbank.onlinebanking.doa.BaseDAO;
import com.openbank.onlinebanking.doa.FundTransferDAO;
import com.openbank.onlinebanking.dto.FundRecipient;

public class FundTransferDAOImpl extends BaseDAO implements FundTransferDAO {

	private static Logger log = LoggerFactory.getLogger(AccountDAOImpl.class);
	
	
	private Query query = null;
	
	public void save(FundRecipient fundRecipient) {
		log.debug("FundRecipient  to save : {}", fundRecipient.toString());
		mongoTemplate.save(fundRecipient, "fundrecipient");
	}

	public List<FundRecipient> getFundRecipient(String profileId, String tenantId) {

		query = new Query(Criteria.where("tenantId").is(tenantId).and("profileId").is(profileId));
		log.debug("Query : " + query);
		List<FundRecipient> fundRecipientList = mongoTemplate.find(query, FundRecipient.class, "fundrecipient");
		return fundRecipientList;
	}
}
