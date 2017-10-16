package com.revature.domain;

public class Account {
	
	//Constructors for creating account
	public Account(int accountID, String accountUser, String accountType, int accountBalance, String openDate) {
		super();
		this.accountID = accountID;
		this.accountUser = accountUser;
		this.accountType = accountType;
		this.accountBalance = accountBalance;
		this.accountDate = openDate;
	}
	public Account() {
		super();
	}
	
	private int accountID;
	private String accountUser;
	private String accountType;
	private int accountBalance;
	private String accountDate;
	
	//Get & set functions
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
	
	//Printing in a column-sort of way
	@Override
	public String toString() {
		return String.format("%-10s %-10s %-10s", accountID, ("$"+accountBalance+".00"), accountType); 
	}
}
