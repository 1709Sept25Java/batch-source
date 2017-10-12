import java.util.List;

public interface UserDao {

	
	public Users login(String username, String password);
	public int createAccount(Users users);
	public int deposit(int bankId, int amount);
	public int overdraft(int bankId, int amount);
}
