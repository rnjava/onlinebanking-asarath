package com.openbank.onlinebanking.form;

import java.util.List;

import com.openbank.onlinebanking.dto.Account;
import com.openbank.onlinebanking.dto.Profile;

public class AccountOverviewForm {

	private String tenantId;
	private Profile profile;
	List<Account> accountList;
	private String firstAccountId;
	
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
	/**
	
	
	/**
	 * @return the accountList
	 */
	public List<Account> getAccountList() {
		return accountList;
	}
	/**
	 * @return the profile
	 */
	public Profile getProfile() {
		return profile;
	}
	/**
	 * @param profile the profile to set
	 */
	public void setProfile(Profile profile) {
		this.profile = profile;
	}
	/**
	 * @param accountList the accountList to set
	 */
	public void setAccountList(List<Account> accountList) {
		this.accountList = accountList;
	}
	/**
	 * @return the firstAccountId
	 */
	public String getFirstAccountId() {
		return firstAccountId;
	}
	/**
	 * @param firstAccountId the firstAccountId to set
	 */
	public void setFirstAccountId(String firstAccountId) {
		this.firstAccountId = firstAccountId;
	}
}
