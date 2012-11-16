package com.openbank.onlinebanking.blo.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.openbank.onlinebanking.blo.LoginService;
import com.openbank.onlinebanking.doa.LoginDAO;
import com.openbank.onlinebanking.dto.User;

public class LoginServiceImpl implements LoginService {

	private LoginDAO loginDAO;
	
	private static Logger log = LoggerFactory.getLogger(LoginServiceImpl.class);
	
	public User login(String userId, String tenantId, String password) {
		log.debug("Entering login({}, {}, {})", new Object[]{userId, tenantId, password});
		User user = loginDAO.getUserByUserId(userId, tenantId);
		if(user == null || !(user.getPassword().equals(password))) {
			user = null;
		}
		log.debug("Exiting - User : {}", user);
		return user;
	}
	
	
	public boolean CreateUser(User user) {
		log.debug("entering........");
		boolean ret = false;
		User exisitingUser = loginDAO.getUserByUserId(user.getUserId(), user.getTenantId());
		if(exisitingUser == null) {
			user.setPassword("test123"); //Fix me;
			loginDAO.saveUser(user);
			ret = true;
		}
		return ret;
	}
	
	public void deleteUser(String userId, String tenantId) {
		loginDAO.deleteUser(userId, tenantId);
	}

	/**
	 * @param loginDAO the loginDAO to set
	 */
	public void setLoginDAO(LoginDAO loginDAO) {
		this.loginDAO = loginDAO;
	}


	public User getUserByProfileId(String tenantId, String profileId) {
		return loginDAO.getUserByProfileId(tenantId, profileId);
	}


	public void updateUser(User user) {
		loginDAO.updateUser(user);
	}
}
