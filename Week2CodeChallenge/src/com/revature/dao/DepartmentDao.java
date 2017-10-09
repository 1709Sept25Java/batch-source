package com.revature.dao;

import com.revature.domain.Department;

public interface DepartmentDao {
	
	public Department getDepartmentById(int id);
	
	public int raiseSalary(int amt);

}
