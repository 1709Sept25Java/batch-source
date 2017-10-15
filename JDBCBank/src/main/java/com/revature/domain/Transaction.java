package com.revature.domain;

public class Transaction {

	public Transaction(int transactionID, int transactionAccount, String transactionType, int transactionPrevious,
			int transactionCurrent, String transactionTime) {
		super();
		this.transactionID = transactionID;
		this.transactionAccount = transactionAccount;
		this.transactionType = transactionType;
		this.transactionPrevious = transactionPrevious;
		this.transactionCurrent = transactionCurrent;
		this.transactionTime = transactionTime;
	}
	public Transaction() {
		super();
	}
	private int transactionID;
	private int transactionAccount;
	private String transactionType;
	private int transactionPrevious;
	private int transactionCurrent;
	private String transactionTime;
	@Override
	public String toString() {
		return "Transaction [transactionID=" + transactionID + ", transactionAccount=" + transactionAccount
				+ ", transactionType=" + transactionType + ", transactionPrevious=" + transactionPrevious
				+ ", transactionCurrent=" + transactionCurrent + ", transactionTime=" + transactionTime + "]";
	}
	public int getTransactionID() {
		return transactionID;
	}
	public void setTransactionID(int transactionID) {
		this.transactionID = transactionID;
	}
	public int getTransactionAccount() {
		return transactionAccount;
	}
	public void setTransactionAccount(int transactionAccount) {
		this.transactionAccount = transactionAccount;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public int getTransactionPrevious() {
		return transactionPrevious;
	}
	public void setTransactionPrevious(int transactionPrevious) {
		this.transactionPrevious = transactionPrevious;
	}
	public int getTransactionCurrent() {
		return transactionCurrent;
	}
	public void setTransactionCurrent(int transactionCurrent) {
		this.transactionCurrent = transactionCurrent;
	}
	public String getTransactionTime() {
		return transactionTime;
	}
	public void setTransactionTime(String transactionTime) {
		this.transactionTime = transactionTime;
	}
}
