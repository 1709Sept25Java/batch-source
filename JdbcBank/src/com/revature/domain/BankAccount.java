package com.revature.domain;

public class BankAccount {

	public BankAccount(Users owner, int balance) {
		super();
		this.owner = owner;
		this.balance = balance;
	}

	public BankAccount() {
		super();
	}

	private int id;
	
	private Users owner;
	
	private int balance;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Users getOwner() {
		return owner;
	}

	public void setOwner(Users owner) {
		this.owner = owner;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "BankAccount [owner=" + owner + ", balance=" + balance + "]";
	}
	
}
