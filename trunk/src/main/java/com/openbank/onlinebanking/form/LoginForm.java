package com.openbank.onlinebanking.form;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class LoginForm {
	@NotEmpty
	@Size(min = 1, max = 50)
	private String userName;
	@NotEmpty
	@Size(min = 1, max = 20)
	private String password;
	
	private String tenantId; 

	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserName() {
		return userName;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPassword() {
		return password;
	}
	/**
	 * @return the tenantId
	 */
	public String getTenantId() {
		return tenantId;
	}
	/**
	 * @param tenantId the tenantId to set
	 */
	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "LoginForm [userName=" + userName + ", password=" + password
				+ ", tenantId=" + tenantId + "]";
	}

	
}
