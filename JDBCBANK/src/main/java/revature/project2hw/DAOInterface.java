package revature.project2hw;

import java.util.List;

public interface DAOInterface {
	
	public List<User> getAllUsers();
	public User getUserId(int userid);
	public User getUser();
	public User getPw();
	public User getBal();
	
	public void Logout(User user);
	public void DeleteAcc(User user);
	public void createAcc(User user);
	public void Transaction(User user);
}
