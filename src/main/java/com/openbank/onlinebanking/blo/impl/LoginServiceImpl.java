package com.openbank.onlinebanking.blo.impl;

import com.openbank.onlinebanking.blo.LoginService;
import com.openbank.onlinebanking.doa.LoginDAO;
import com.openbank.onlinebanking.dto.User;

public class LoginServiceImpl implements LoginService {

	private LoginDAO loginDAO;
	
	public User login(String userId, String tenantId, String password) {
		User user = loginDAO.getUserByUserId(userId, tenantId);
		if(user == null || !(user.getPassword().equals(password))) {
			//profileId = user.getProfileId();
			user = null;
		}
		return user;
	}

	/**
	 * @param loginDAO the loginDAO to set
	 */
	public void setLoginDAO(LoginDAO loginDAO) {
		this.loginDAO = loginDAO;
	}
}
