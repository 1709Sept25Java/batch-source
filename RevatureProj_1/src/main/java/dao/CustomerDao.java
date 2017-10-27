package dao;

import java.util.List;


import domain.Customer;

public interface CustomerDao {

	public List <Customer> getCustomer();
	public Customer getCustomerById(int id);
	public int createCustomer(Customer customer);
}
