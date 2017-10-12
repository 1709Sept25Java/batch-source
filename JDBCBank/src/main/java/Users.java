
public class Users {

	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Users(String username, String password, BankAccount bankaccid) {
		super();
		this.username = username;
		this.password = password;
		this.bankaccid = bankaccid;
	}
	public Users(int userID, String username, String password, BankAccount bankaccid) {
		super();
		this.userID = userID;
		this.username = username;
		this.password = password;
		this.bankaccid = bankaccid;
	}
	private int userID;
	private String username;
	private String password;
	private BankAccount bankaccid;
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public BankAccount getBankaccid() {
		return bankaccid;
	}
	public void setBankaccid(BankAccount bankaccid) {
		this.bankaccid = bankaccid;
	}
	@Override
	public String toString() {
		return "Users [userID=" + userID + ", username=" + username + ", password=" + password + ", bankaccid="
				+ bankaccid + "]";
	}
	
}
