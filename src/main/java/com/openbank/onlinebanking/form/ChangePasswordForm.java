package com.openbank.onlinebanking.form;

import com.openbank.onlinebanking.form.staff.StaffBaseForm;

public class ChangePasswordForm extends StaffBaseForm {
	
	
	private String currentPassword;
	private String newPassword;
	private String newPasswordRep;
	/**
	 * @return the currentPassword
	 */
	public String getCurrentPassword() {
		return currentPassword;
	}
	/**
	 * @param currentPassword the currentPassword to set
	 */
	public void setCurrentPassword(String currentPassword) {
		this.currentPassword = currentPassword;
	}
	/**
	 * @return the newPassword
	 */
	public String getNewPassword() {
		return newPassword;
	}
	/**
	 * @param newPassword the newPassword to set
	 */
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	/**
	 * @return the newPasswordRep
	 */
	public String getNewPasswordRep() {
		return newPasswordRep;
	}
	/**
	 * @param newPasswordRep the newPasswordRep to set
	 */
	public void setNewPasswordRep(String newPasswordRep) {
		this.newPasswordRep = newPasswordRep;
	}
	
	

}
