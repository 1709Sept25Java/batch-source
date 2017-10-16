package com.JDBCBank.DAO;

import java.util.List;

import com.JDBCBank.domain.Users;
import com.JDBCBank.exceptions.InvalidPasswordException;
import com.JDBCBank.exceptions.UserDoesNotExistException;

public interface UsersDao {

	public List<Users> getUsers();
	
	public int getUserId(String username, String password);
	
	public boolean isValidUser(String username, String password) throws UserDoesNotExistException, InvalidPasswordException;
	
	public boolean isValidPassword(String username, String password) throws InvalidPasswordException;
	
	public int getUserTypeId(String username);
	
	public int createUser(Users usr);
	
	public int updatePassword(int u_id, String new_pw);
	
	public int deleteUser(int u_id);
	

}
