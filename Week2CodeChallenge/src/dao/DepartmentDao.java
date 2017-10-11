package dao;

import java.util.List;

import domain.*;

public interface DepartmentDao {

	public List<Department> getDepartment();
	public Department getDepartmentById(int id);
}
