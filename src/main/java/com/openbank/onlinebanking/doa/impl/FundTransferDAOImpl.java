package com.openbank.onlinebanking.doa.impl;

import com.openbank.onlinebanking.doa.BaseDAO;
import com.openbank.onlinebanking.doa.FundTransferDAO;
import com.openbank.onlinebanking.dto.FundRecipient;

public class FundTransferDAOImpl extends BaseDAO implements FundTransferDAO {

	@Override
	public void save(FundRecipient fundRecipient) {
		mongoTemplate.save(fundRecipient, "fundrecipient");
	}

}
