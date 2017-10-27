package domain;

public class Employer {

	public Employer() {
		super();
	}
	
	public Employer(String username, String password) {
		super();
		String admin="admin";
		String pass="pw";
		Customer c= new Customer();
		
		username=c.getUsername();
		password=c.getPassword();
		admin=username;
		pass=password;
	}
}

