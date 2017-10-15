package com.revature.dao;

import java.util.List;

import com.revature.domain.BankAccount;
import com.revature.exception.OverdraftException;
import com.revature.util.ConnectionUtil;

public interface BankAccountDao {

	//Function to list all the accounts the User has
	public List<BankAccount> getAccounts(int uId);
	
	//Function to delete the account the user holds with a given id
	public boolean deleteAccount(int uId,int id);
	
	//Function to create a new account for the user with the id given
	public boolean createAccount(int uId);
	
	//Function to withdraw the amount of money given from the account with the matching id
	public int withdraw(BankAccount b,int amt) throws OverdraftException;
	
	//Function to deposit the given amount of money from the account with the matching id
	public int deposit(int id,int amt);
	
}
