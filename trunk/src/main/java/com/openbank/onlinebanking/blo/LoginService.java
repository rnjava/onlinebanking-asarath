package com.openbank.onlinebanking.blo;

import com.openbank.onlinebanking.dto.User;


public interface LoginService {

	User login(String userId, String tenantId, String password);
	boolean CreateUser(User user);
	void deleteUser(String userId, String tenantId);
	User getUserByProfileId(String tenantId, String profileId);
	public void updateUser(User user);
}
