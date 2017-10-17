package com.revature.DAO;

import java.util.List;

public interface CustomerDAO {

	public Customer newCustomer();
	
	public List<Customer> listCustomers();
	
	public int checkBalance(Account);
	
	public int deposit();
	
	public int withdraw();
	
	
	
}
