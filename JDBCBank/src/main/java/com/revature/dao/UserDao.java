package com.revature.dao;

import java.util.List;

import com.revature.domain.*;

public interface UserDao {
	public Boolean createAccount(String type, int balance);
	
	public List<Account> viewAccounts();
	
	public List<Transaction> viewTransactions();
	
}
