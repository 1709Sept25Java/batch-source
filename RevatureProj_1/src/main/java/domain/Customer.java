package domain;

public class Customer {
	
	public Customer()
	{
		super();
	}
	
	private int userId;
	private String username;
	private String password;
	private String firstname;
	private String lastname;
	private String email;
	
	public Customer(int userId, String username,String firstname,String lastname, String email) {
		super();
		this.setUserId(userId);
		this.setUsername(username);
		this.setFirstname(firstname);
		this.setLastname(lastname);
		this.setEmail(email);
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPasssword(String passsword) {
		this.password = passsword;
	}

}
