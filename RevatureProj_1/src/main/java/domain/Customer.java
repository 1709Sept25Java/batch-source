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
	
	//reimbursements
	private int reinburse;
	private int r_Amount;
	private String r_Type;
	private String r_Status;
	
	public Customer(int userId, String username,String password, String firstname,String lastname, String email, int reinburseid) {
		super();
		this.setUserId(userId);
		this.setUsername(username);
		this.setPassword(password);
		this.setFirstname(firstname);
		this.setLastname(lastname);
		this.setEmail(email);
		this.setReinburse(reinburseid);
	}
	
	public Customer(String username,String password) {
		super();
		this.setUsername(username);
		this.setPassword(password);
	}
	
	public Customer(int reinburseId, int r_Amount, String r_Type, String r_Status) {
		super();
		this.setReinburse(reinburseId);
		this.setR_Amount(r_Amount);
		this.setR_Type(r_Type);
		this.setR_Status(r_Status);
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

	public void setPassword(String password) {
		this.password = password;
	}

	public int getReinburse() {
		return reinburse;
	}

	public void setReinburse(int reinburse) {
		this.reinburse = reinburse;
	}
	
	public String toString(int id) {
		return "Customer";
	}

	public int getR_Amount() {
		return r_Amount;
	}

	public void setR_Amount(int r_Amount) {
		this.r_Amount = r_Amount;
	}

	public String getR_Type() {
		return r_Type;
	}

	public void setR_Type(String r_Type) {
		this.r_Type = r_Type;
	}

	public String getR_Status() {
		return r_Status;
	}

	public void setR_Status(String r_Status) {
		this.r_Status = r_Status;
	}

}
