package com.revature.dao;

public interface AdminDao {

	public void viewUsers();
	
	public void createUser();

	public void updateUser();
	
	public void deleteUser();

	public boolean loggedIn();

	public void session();
	
}
