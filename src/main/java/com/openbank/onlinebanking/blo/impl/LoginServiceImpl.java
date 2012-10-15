package com.openbank.onlinebanking.blo.impl;

import com.openbank.onlinebanking.blo.LoginService;
import com.openbank.onlinebanking.doa.LoginDAO;
import com.openbank.onlinebanking.dto.User;
import com.openbank.onlinebanking.form.LoginForm;

public class LoginServiceImpl implements LoginService {

	private LoginDAO loginDAO;
	
	@Override
	public boolean login(LoginForm loginForm) {
		boolean isLoginSucess = false;
		User user = loginDAO.getUserByUserId(loginForm.getUserName());
		if("password".equalsIgnoreCase(loginForm.getPassword())) {
			isLoginSucess = true;
		}
		return isLoginSucess;
	}

	/**
	 * @param loginDAO the loginDAO to set
	 */
	public void setLoginDAO(LoginDAO loginDAO) {
		this.loginDAO = loginDAO;
	}
}
