package com.revature.dao;
import com.revature.domain.User;

public interface EmployeeDao {
	public User getUserById(int id);
	public int updateEmployeeById(int id, String un, String pw, String fn, String ln, String em);	
}
