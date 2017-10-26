package com.revature.dao;

import java.util.List;

import com.revature.domain.Employee;

public interface EmployeeDao {

	//Function to retrieve user from the database on log in
	public Employee login(String username,String password);
	
	//Function to retrieve user data by id
	public Employee empInfo(int uId);
	
	//Function to retrieve all the Employees who are not managers from the databse
	public List<Employee> getEmployees();
	
	//Function to update the Employee info
	public boolean updateInfo(int eId,String uname,String fname,String lname,String email);
	
	//Function to update Employee password
	public boolean updatePw(int eId,String pw);
	
}
