package com.JDBCBank.domain;

import java.util.Date;

public class Transactions {
	private int transactionId;
	private Date date;
	private int bankAccountId;
	
	
	public Transactions() {
		super();
	}

	public Transactions(int transactionId, Date date) {
		super();
		this.transactionId = transactionId;
		this.date = date;
		
	}
	
	public Transactions(int transactionId, Date date, int bankAccountId) {
		super();
		this.transactionId = transactionId;
		this.date = date;
		this.bankAccountId = bankAccountId;
		
	}

	@Override
	public String toString() {
		return "Transactions [transactionId=" + transactionId + ", date=" + date + ", bankAccountId="
				+ bankAccountId + "]";
	}

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getBankAccountId() {
		return bankAccountId;
	}

	public void setBankAccountId(int bankAccountId) {
		this.bankAccountId = bankAccountId;
	}

}
