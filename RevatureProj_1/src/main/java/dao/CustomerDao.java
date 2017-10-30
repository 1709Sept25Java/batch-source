package dao;

import java.util.List;


import domain.Customer;

public interface CustomerDao {

	public List <Customer> getCustomer();
	public void createCustomer(String user1, String pass1, String fname, String lname, String email);
	
	public Customer updateCustomer();
	int deleteCustomer(Customer delete);
	
	public Customer getCustomerById(int id);
	public String getCustomerIdString(int id);
	
	public Customer getCustomerByUser(String user);
	String getCustomerUserString(String user);
	
	public Customer getCustomerAcc();
	String getCustomerAccString();
	
	public Customer getCustomerAccById(int id);
	String getCustomerAccStringById(int id);
	
	public void sendBlob(String file, int id);
	
	public Customer getCustomerAccByUser(String user);
	String getCustomerAccStringByUser(String user);
	
}
