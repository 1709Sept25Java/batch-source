package com.revature.ERS_DAO;

import java.util.List;

import com.revature.domain.Employee;

public interface EmployeeDao {
	
	 public List<Employee> getEmps();
	 public Employee getEmpById(int emplid);
	 public List<Employee> getEmpByFirstName(String firstName);
	 public List<Employee> getEmpByLastName(String lastName);
	 public int addEmployee(String firstName,String lastName,String email);

}
