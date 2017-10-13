package com.revature.dao;

import com.revature.domain.BankAccount;

public interface BankAccountDao {

	public BankAccount getAccounts(int uId);
	
	public boolean deleteAccount(int id);
	
	public boolean createAccount(int id);
	
	public boolean withdraw(int id,double amt);
	
	public boolean deposit(int id,double amt);
	
}
