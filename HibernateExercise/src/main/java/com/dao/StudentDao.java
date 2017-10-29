package com.dao;

import java.util.List;

import com.domain.Student;

public interface StudentDao {

	public List<Student> getStudent();
	public int addStudent(Student s);
}
