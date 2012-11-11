package com.openbank.onlinebanking.doa.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.openbank.onlinebanking.doa.BaseDAO;
import com.openbank.onlinebanking.doa.FundTransferDAO;
import com.openbank.onlinebanking.dto.FundRecipient;

public class FundTransferDAOImpl extends BaseDAO implements FundTransferDAO {

	private static Logger log = LoggerFactory.getLogger(AccountDAOImpl.class);
	
	public void save(FundRecipient fundRecipient) {
		log.debug("FundRecipient  to save : {}", fundRecipient.toString());
		mongoTemplate.save(fundRecipient, "fundrecipient");
	}

}
