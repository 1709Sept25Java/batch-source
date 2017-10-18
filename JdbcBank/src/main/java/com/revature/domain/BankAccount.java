package com.revature.domain;

public class BankAccount {

	public BankAccount(int id, int owner, int balance) {
		super();
		this.id = id;
		this.owner = owner;
		this.balance = balance;
	}

	public BankAccount(int owner, int balance) {
		super();
		this.owner = owner;
		this.balance = balance;
	}

	public BankAccount() {
		super();
	}

	private int id;
	
	private int owner;
	
	private int balance;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getOwner() {
		return owner;
	}

	public void setOwner(int owner) {
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
		return "BankAccount : id= "+ id + ", balance=" + balance;
	}
}
