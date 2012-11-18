package com.openbank.onlinebanking.form.admin;

import org.springframework.web.multipart.MultipartFile;

import com.openbank.onlinebanking.form.staff.StaffBaseForm;

public class AdministrationForm extends StaffBaseForm {
	
	private String tenantName;
	private String primaryContact;
	private String phoneNo;
	private String emailAddress;
	private String address;
	private String searchTenantId;
	private String searchName;
	MultipartFile file;
	
	
	/**
	 * @return the tenantName
	 */
	public String getTenantName() {
		return tenantName;
	}
	/**
	 * @param tenantName the tenantName to set
	 */
	public void setTenantName(String tenantName) {
		this.tenantName = tenantName;
	}
	/**
	 * @return the primaryContact
	 */
	public String getPrimaryContact() {
		return primaryContact;
	}
	/**
	 * @param primaryContact the primaryContact to set
	 */
	public void setPrimaryContact(String primaryContact) {
		this.primaryContact = primaryContact;
	}
	/**
	 * @return the phoneNo
	 */
	public String getPhoneNo() {
		return phoneNo;
	}
	/**
	 * @param phoneNo the phoneNo to set
	 */
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	/**
	 * @return the emailAddress
	 */
	public String getEmailAddress() {
		return emailAddress;
	}
	/**
	 * @param emailAddress the emailAddress to set
	 */
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return the searchTenantId
	 */
	public String getSearchTenantId() {
		return searchTenantId;
	}
	/**
	 * @param searchTenantId the searchTenantId to set
	 */
	public void setSearchTenantId(String searchTenantId) {
		this.searchTenantId = searchTenantId;
	}
	/**
	 * @return the searchName
	 */
	public String getSearchName() {
		return searchName;
	}
	/**
	 * @param searchName the searchName to set
	 */
	public void setSearchName(String searchName) {
		this.searchName = searchName;
	}
	/**
	 * @return the file
	 */
	public MultipartFile getFile() {
		return file;
	}
	/**
	 * @param file the file to set
	 */
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	
	
	

}
