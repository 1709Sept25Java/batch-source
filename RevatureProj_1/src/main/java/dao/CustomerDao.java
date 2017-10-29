package dao;

import java.util.List;


import domain.Customer;

public interface CustomerDao {

	public List <Customer> getCustomer();
	public int createCustomer(Customer customer);
	
	public Customer updateCustomer(String update);
	int deleteCustomer(Customer delete);
	
	public Customer getCustomerById(int id);
	public String getCustomerIdString(int id);
	
	public Customer getCustomerByUser(String user);
	String getCustomerUserString(String user);
	
	public Customer getCustomerAcc();
	String getCustomerAccString();
	
	public Customer getCustomerAccById(int id);
	String getCustomerAccStringById(int id);
}
