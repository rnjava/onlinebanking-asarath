package com.openbank.onlinebanking.blo;

import com.openbank.onlinebanking.dto.User;


public interface LoginService {

	User login(String userId, String tenantId, String password);
}
