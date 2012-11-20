package com.openbank.onlinebanking.blo.impl;

import java.util.List;

import com.openbank.onlinebanking.blo.FundTransferService;
import com.openbank.onlinebanking.doa.FundTransferDAO;
import com.openbank.onlinebanking.dto.FundRecipient;

public class FundTransferServiceImpl implements FundTransferService {
	
	private FundTransferDAO fundTransferDAO; 

	
	public void createFundRecipient(FundRecipient fundRecipient) {
		fundTransferDAO.save(fundRecipient);
	}

	/**
	 * @param fundTransferDAO the fundTransferDAO to set
	 */
	public void setFundTransferDAO(FundTransferDAO fundTransferDAO) {
		this.fundTransferDAO = fundTransferDAO;
	}

	public List<FundRecipient> getFundRecipient(String profileId, String tenantId) {
		return fundTransferDAO.getFundRecipient(profileId, tenantId);
	}
	
	
}
