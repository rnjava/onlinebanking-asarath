package com.openbank.onlinebanking.dto;


import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Account {

	
	private String accountNo;
	private String type;
	private double balance;
	private String currencySymbol;

	  
	
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
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * @return the balance
	 */
	public double getBalance() {
		return balance;
	}
	/**
	 * @param balance the balance to set
	 */
	public void setBalance(double balance) {
		this.balance = balance;
	}
	/**
	 * @return the currencySymbol
	 */
	public String getCurrencySymbol() {
		return currencySymbol;
	}
	/**
	 * @param currencySymbol the currencySymbol to set
	 */
	public void setCurrencySymbol(String currencySymbol) {
		this.currencySymbol = currencySymbol;
	}
	
	
}
