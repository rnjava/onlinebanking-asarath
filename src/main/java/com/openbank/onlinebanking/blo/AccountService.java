package com.openbank.onlinebanking.blo;

import java.util.List;

import com.openbank.onlinebanking.dto.Account;

public interface AccountService {

	List<Account> getAccountsByProfileId(String profileId, String tenantId);

}
