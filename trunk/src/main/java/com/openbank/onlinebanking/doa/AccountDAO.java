package com.openbank.onlinebanking.doa;

import java.util.List;

import com.openbank.onlinebanking.dto.Account;

public interface AccountDAO {

	List<Account> getAccountsByProfileId(String profileId, String tenantId);

}
