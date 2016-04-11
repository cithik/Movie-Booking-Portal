package com.me.moviebooking.model;

import java.util.Date;

public class AccountDetails {
	int customerId;
	int accountNumber;
	AccountType accountType;
	public enum AccountType {
	    MASTER, VISA
	}
	Date expiaryDate;

	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	public AccountType getAccountType() {
		return accountType;
	}
	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}
	public Date getExpiaryDate() {
		return expiaryDate;
	}
	public void setExpiaryDate(Date expiaryDate) {
		this.expiaryDate = expiaryDate;
	}
}
