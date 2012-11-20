package com.openbank.onlinebanking.doa;

import java.util.List;

import com.openbank.onlinebanking.dto.FundRecipient;

public interface FundTransferDAO {

	void save(FundRecipient fundRecipient);
	List<FundRecipient> getFundRecipient(String profileId, String tenantId);

}
