package com.revature.dao;

import java.util.List;

import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;

import com.revature.domain.Student;

public interface StudentDao {
	
	public List<Student> getStudents();
	public Student getStudent(int id);
	public int addStudent(Student f);
	public void deleteStudent(Student f);
	public void updateStudent(Student f);

}
