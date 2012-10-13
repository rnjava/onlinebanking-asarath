package com.openbank.onlinebanking.blo.impl;

import com.openbank.onlinebanking.blo.LoginService;
import com.openbank.onlinebanking.form.LoginForm;

public class LoginServiceImpl implements LoginService {

	@Override
	public boolean login(LoginForm loginForm) {
		boolean isLoginSucess = false;
		if("password".equalsIgnoreCase(loginForm.getPassword())) {
			isLoginSucess = true;
		}
		return isLoginSucess;
	}

	
}
