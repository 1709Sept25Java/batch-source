package com.revature.dao;

import java.util.List;

import com.revature.domain.Users;
import com.revature.exception.InvalidUserException;
import com.revature.exception.UserNotCreatedException;
import com.revature.util.ConnectionUtil;

public interface UsersDao {

	//Function to allow user login by querying the database for the matching credentials
	public Users login(String username,String password) throws InvalidUserException;
	
	//Function to Show all the users in the database
	public List<Users> getUsers(int id);
	
	//Function to delete a user with the given id
	public boolean deleteUser(int id);
	
	//Function to create a new user in the database
	public boolean createUser(String username,String password,String isAdmin) throws UserNotCreatedException;
	
	//Function to update user, giving or taking admin flag
	public boolean updateUser(int uId, String isAdm);
}
