package dao;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Users {

	public Users() {
		super();
	}
	public Users(int userId, String username, String password, String firstname, String lastname, String email,
			UserRoles userRoleId) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.userRoleId = userRoleId;
	}
	private int userId;
	private String username;
	private String password;
	private String firstname;
	private String lastname;
	private String email;
	private UserRoles userRoleId;
	@XmlAttribute
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	@XmlAttribute
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@XmlAttribute
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@XmlAttribute
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	@XmlAttribute
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	@XmlAttribute
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@XmlAttribute
	public UserRoles getUserRoleId() {
		return userRoleId;
	}
	public void setUserRoleId(UserRoles userRoleId) {
		this.userRoleId = userRoleId;
	}
	@Override
	public String toString() {
		return "Users [userId=" + userId + ", username=" + username + ", password=" + password + ", firstname="
				+ firstname + ", lastname=" + lastname + ", email=" + email + ", userRoleId=" + userRoleId + "]";
	}
}
