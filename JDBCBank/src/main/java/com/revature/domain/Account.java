package com.revature.domain;

public class Account {
	public Account(int accountID, String accountUser, String accountType, int accountBalance) {
		super();
		this.accountID = accountID;
		this.accountUser = accountUser;
		this.accountType = accountType;
		this.accountBalance = accountBalance;
	}
	public Account() {
		super();
	}
	private int accountID;
	private String accountUser;
	private String accountType;
	private int accountBalance;
	public int getAccountID() {
		return accountID;
	}
	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}
	public String getAccountUser() {
		return accountUser;
	}
	public void setAccountUser(String accountUser) {
		this.accountUser = accountUser;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public int getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(int accountBalance) {
		this.accountBalance = accountBalance;
	}
	@Override
	public String toString() {
		return "Account [accountID=" + accountID + ", accountUser=" + accountUser + ", accountType=" + accountType
				+ ", accountBalance=" + accountBalance + "]";
	}
}
