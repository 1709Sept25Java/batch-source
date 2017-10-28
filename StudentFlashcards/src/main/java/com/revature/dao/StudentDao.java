package com.revature.dao;

import java.util.List;

import com.revature.domain.Student;


public interface StudentDao {

	public List<Student> getStudents();
	public Student getStudentById(int id);
	public int addStudent(Student s);
	public void updateStudent(Student s);
	//public void deleteStudent(Student s);
}
