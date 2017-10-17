package com.revature.DAO;

import java.util.List;

public interface UserDAO {
	
	public User newUser();
	
	public List<User> listUsers();
	
	public void login();
	
	public void logout();
	
	public void changePassword();
	
	public void deleteAccount();

}
