package com.openbank.onlinebanking.form.staff;

import com.openbank.onlinebanking.dto.Account;
import com.openbank.onlinebanking.dto.Profile;

public class SearchResultForm extends StaffBaseForm {
	
	private String accountNo;
	private String userFirstName;
    private String userLastName;
	private String userProfileId;
	private Profile profile;
	private Account account;


	/**
	 * @return the accountNo
	 */
	public String getAccountNo() {
		return accountNo;
	}
	/**
	 * @param accountNo the accountNo to set
	 */
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	/**
	 * @return the userFirstName
	 */
	public String getUserFirstName() {
		return userFirstName;
	}
	/**
	 * @param userFirstName the userFirstName to set
	 */
	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}
	/**
	 * @return the userLastName
	 */
	public String getUserLastName() {
		return userLastName;
	}
	/**
	 * @param userLastName the userLastName to set
	 */
	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}
	/**
	 * @return the userProfileId
	 */
	public String getUserProfileId() {
		return userProfileId;
	}
	/**
	 * @param userProfileId the userProfileId to set
	 */
	public void setUserProfileId(String userProfileId) {
		this.userProfileId = userProfileId;
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
	 * @return the account
	 */
	public Account getAccount() {
		return account;
	}
	/**
	 * @param account the account to set
	 */
	public void setAccount(Account account) {
		this.account = account;
	}

	
}
