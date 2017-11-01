package ers.dao;

import java.util.List;

import ers.domain.Users;

public interface UsersDao {
	
	public int getUserRoleId(String username, String password);
	
	public boolean isValidUsername(String username);
	
	public boolean isValidPassword(String username, String password);
	
	public Users createUser(String username, String password);
	
	public void updateUsers(String username, String col, String newVal);

	public List<Users> getEmployees();
	
	public String getUsername(int id);
	
	public int getUserId(String username);
}
