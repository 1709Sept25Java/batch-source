package com.revature.dao;

import com.revature.domain.Employee;

public interface EmployeeDao {

	//Function to retrieve user from the database on log in
	public Employee login(String username,String password);
	
}
