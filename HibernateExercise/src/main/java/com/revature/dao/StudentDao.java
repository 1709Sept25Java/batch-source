package com.revature.dao;

import java.util.List;

import com.revature.domain.Student;

public interface StudentDao {

	public List<Student> getStudent();
	
	public int addStudent(Student s);
	
}
