package bank.dao;

import java.util.List;

import bank.domain.Users;
import bank.exceptions.InvalidPasswordException;
import bank.exceptions.UsernameDoesNotExistException;

public interface UsersDao {

	public List<Users> getUsers();
	
	public int getUserId(String username, String password);
	
	public boolean isValidUser(String username, String password) throws UsernameDoesNotExistException, InvalidPasswordException;
	
	public boolean isValidPassword(String username, String password) throws InvalidPasswordException;
	
	public int getUserTypeId(String username);
	
	public int createUser(Users usr);
	
	public int updatePassword(int u_id, String new_pw);
	
	public int deleteUser(int u_id);
}
