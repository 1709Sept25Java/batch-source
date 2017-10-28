package com.revature.dao;

import java.util.List;

import org.hibernate.Session;

import com.revature.domain.Student;
import com.revature.util.HibernateUtil;

public class StudentDaoImpl implements StudentDao{

	@Override
	public List<Student> getStudent() {
		Session s = HibernateUtil.getSession();
		List<Student> student = s.createQuery("from Student").list();
			for(Student stdt : student){
				System.out.println(stdt);
			}
		s.close();
		return student;
	}

	@Override
	public Student getStudentById(int id) {
		Session s = HibernateUtil.getSession();
		Student stdt = (Student) s.get(Student.class, id); 
		s.close();
		return stdt;
	}

	@Override
	public int addStudent(Student s) {
		return 0;
	}

	@Override
	public void updateStudent(Student s) {
	
	}

	@Override
	public void deleteStudent(Student s) {
	
	}

}
