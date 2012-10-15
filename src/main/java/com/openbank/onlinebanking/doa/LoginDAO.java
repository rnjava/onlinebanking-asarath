package com.openbank.onlinebanking.doa;

import com.openbank.onlinebanking.dto.User;

public interface LoginDAO {

	User getUserByUserId(String userName, String tenantId);

}
