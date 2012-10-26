package com.openbank.onlinebanking.dto;

public class FundRecipient {
	
	private String tenantId;
	private String profileId;
	private String lastName;
	private String nickName;
	private String recipientAccountId;
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
	 * @return the profileId
	 */
	public String getProfileId() {
		return profileId;
	}
	/**
	 * @param profileId the profileId to set
	 */
	public void setProfileId(String profileId) {
		this.profileId = profileId;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the nickName
	 */
	public String getNickName() {
		return nickName;
	}
	/**
	 * @param nickName the nickName to set
	 */
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	/**
	 * @return the recipientAccountId
	 */
	public String getRecipientAccountId() {
		return recipientAccountId;
	}
	/**
	 * @param recipientAccountId the recipientAccountId to set
	 */
	public void setRecipientAccountId(String recipientAccountId) {
		this.recipientAccountId = recipientAccountId;
	}
	
	

}
