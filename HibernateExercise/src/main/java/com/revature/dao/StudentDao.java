package com.revature.dao;

import com.revature.domain.Student;

public interface StudentDao {

	Student getStudent(int id);
	
	void addStudent(String fname,String lname);
	
}
