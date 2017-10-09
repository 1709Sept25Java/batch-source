package com.revature.sql;
import com.revature.sql.Department;
import java.awt.List;

public interface DepartmentDao {
public List getDepartment();
	
	public Department getDepartmentById(int id);
	
	public int DepSalary(int DepId, int salary);
	
	

}
