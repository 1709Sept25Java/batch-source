package com.revature.dao;


public interface AccountDao {
	public void deleteAccount();
	public void depositAccount();
	public void withdrawAccount() throws AccountOverdraftException;
	public void session();
}
