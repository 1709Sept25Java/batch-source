
public class Users {

	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Users(String username, String password, UserType usertype) {
		super();
		this.username = username;
		this.password = password;
		this.usertype = usertype;
	}
	public Users(int userID, String username, String password, UserType usertype) {
		super();
		this.userID = userID;
		this.username = username;
		this.password = password;
		this.usertype = usertype;
	}
	private int userID;
	private String username;
	private String password;
	private UserType usertype;
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
	public UserType getUsertype() {
		return usertype;
	}
	public void setUsertype(UserType usertype) {
		this.usertype = usertype;
	}
	@Override
	public String toString() {
		return "Users [userID=" + userID + ", username=" + username + ", password=" + password + ", UserType="
				+ usertype + "]";
	}
	
}
