package com.openbank.onlinebanking.form.staff;

public class DepositForm extends StaffBaseForm {
	
	private String accountNo;
	private Double amount;
	private String mode;
	private boolean isApprovalNeeded;
	private String description;
	
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
	 * @return the amount
	 */
	public Double getAmount() {
		return amount;
	}
	/**
	 * @param amount the amount to set
	 */
	public void setAmount(Double amount) {
		this.amount = amount;
	}

	/**
	 * @return the isApprovalNeeded
	 */
	public boolean isApprovalNeeded() {
		return isApprovalNeeded;
	}
	/**
	 * @param isApprovalNeeded the isApprovalNeeded to set
	 */
	public void setApprovalNeeded(boolean isApprovalNeeded) {
		this.isApprovalNeeded = isApprovalNeeded;
	}
	/**
	 * @return the mode
	 */
	public String getMode() {
		return mode;
	}
	/**
	 * @param mode the mode to set
	 */
	public void setMode(String mode) {
		this.mode = mode;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	

}
