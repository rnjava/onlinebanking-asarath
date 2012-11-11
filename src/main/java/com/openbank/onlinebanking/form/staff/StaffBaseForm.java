package com.openbank.onlinebanking.form.staff;

import com.openbank.onlinebanking.form.BaseForm;

public class StaffBaseForm extends BaseForm {
	
	private String staffProfileId;
	private String staffFirstName;
    private String staffLastName;
	/**
	 * @return the staffProfileId
	 */
	public String getStaffProfileId() {
		return staffProfileId;
	}
	/**
	 * @param staffProfileId the staffProfileId to set
	 */
	public void setStaffProfileId(String staffProfileId) {
		this.staffProfileId = staffProfileId;
	}
	/**
	 * @return the staffFirstName
	 */
	public String getStaffFirstName() {
		return staffFirstName;
	}
	/**
	 * @param staffFirstName the staffFirstName to set
	 */
	public void setStaffFirstName(String staffFirstName) {
		this.staffFirstName = staffFirstName;
	}
	/**
	 * @return the staffLastName
	 */
	public String getStaffLastName() {
		return staffLastName;
	}
	/**
	 * @param staffLastName the staffLastName to set
	 */
	public void setStaffLastName(String staffLastName) {
		this.staffLastName = staffLastName;
	}
    
    

}
