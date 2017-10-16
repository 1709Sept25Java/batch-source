package com.revature.dao;

import java.util.List;

import com.revature.domain.AccountHolder;

public interface AccountHolderDao {

	
	public AccountHolder getAccountHolderbyId(int id);
	
	public int transaction(int id, String type, int amt);
	
	public int createAccountHolder(AccountHolder accountholder);

	public List<AccountHolder> getAccountHolder();
}
