package com.openbank.onlinebanking.form.staff;

public class WithdrawalForm extends StaffBaseForm {

	private String accountNo;
	private Double amount;
	private String withDrawalType;
	private boolean isApprovalNeeded;
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
	 * @return the withDrawalType
	 */
	public String getWithDrawalType() {
		return withDrawalType;
	}
	/**
	 * @param withDrawalType the withDrawalType to set
	 */
	public void setWithDrawalType(String withDrawalType) {
		this.withDrawalType = withDrawalType;
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
	
	
}
