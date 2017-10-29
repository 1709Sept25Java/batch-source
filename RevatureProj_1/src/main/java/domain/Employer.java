package domain;

public class Employer {

	public Employer() {
		super();
	}
	
	public Employer(String username, String password) {
		super();
		Customer c= new Customer();
		
		username=c.getUsername();
		password=c.getPassword();
		//user: admin, password:pw, a special type of customer
	}
}

