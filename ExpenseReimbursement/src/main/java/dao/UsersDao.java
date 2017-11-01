package dao;

import java.util.List;

public interface UsersDao {

	public Users getUserByUsername(String username);
	public Users getUserById(int userId);
	public List<Users> getAllUsers();
	public boolean isValidUser(String username, String password);
	public boolean isValidPass(String username, String password);
	public int checkManager(String username);
	public boolean empUpdate(String username, String firstname,String lastname, String email);
	public boolean empResetPass(String username, String password);
	
}
