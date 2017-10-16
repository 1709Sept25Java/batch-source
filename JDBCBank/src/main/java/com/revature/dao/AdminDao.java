package com.revature.dao;

import com.revature.bank.DuplicateUsernameException;

public interface AdminDao {

	public void viewUsers();
	
	public void createUser() throws DuplicateUsernameException;

	public void updateUser();
	
	public void deleteUser();

	public boolean loggedIn();

	public void session();
	
}
