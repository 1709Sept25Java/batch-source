package com.revature.dao;

import java.util.List;

import com.revature.domain.Departments;

public interface DepartmentsDao {
		public List<Departments> getDepts();
		public Departments getDeptById(int id);
}
