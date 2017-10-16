import java.util.List;

public interface UserDao {

	public List<Users> getUsers();
	public Users login(String u, String p);
	public int createAccount(Users users);
	public Users getUsersById(int userId);
	public String adminCreate(String user, String pass, int typeid);
	public String adminUpdate(int userid,String users,String pass, int typeid);
	public String adminDelete(int userid);
	
	
}
