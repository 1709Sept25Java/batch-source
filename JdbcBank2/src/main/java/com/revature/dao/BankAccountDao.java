package com.revature.dao;

import java.util.List;

import com.revature.domain.BankAccount;
import com.revature.util.ConnectionUtil;

public interface BankAccountDao {

	public List<BankAccount> getAccounts(int uId,ConnectionUtil cu);
	
	public boolean deleteAccount(int uId,int id,ConnectionUtil cu);
	
	public boolean createAccount(int uId,ConnectionUtil cu);
	
	public int withdraw(int id,double amt,ConnectionUtil cu);
	
	public int deposit(int id,double amt,ConnectionUtil cu);
	
}
