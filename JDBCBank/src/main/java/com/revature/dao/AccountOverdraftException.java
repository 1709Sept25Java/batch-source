package com.revature.dao;

//Account: Check balance of account and only withdraw if there is enough balance
public class AccountOverdraftException extends Exception {

	private static final long serialVersionUID = 1L;

	public AccountOverdraftException(String message) {
		super(message);
	}

}
