package com.openbank.onlinebanking.blo;

import java.util.List;

import com.openbank.onlinebanking.dto.FundRecipient;

public interface FundTransferService {

	void createFundRecipient(FundRecipient fundRecipient);
	List<FundRecipient> getFundRecipient(String profileId, String tenantId);

}
