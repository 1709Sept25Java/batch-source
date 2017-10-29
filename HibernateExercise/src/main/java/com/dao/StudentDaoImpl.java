package com.dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.domain.Student;
import com.util.HibernateUtil;

public class StudentDaoImpl implements StudentDao{

	@Override
	public List<Student> getStudent() {
		Session s = HibernateUtil.getSession();
		List<Student> students = s.createQuery("from Student").list();
		for(Student st : students) {
			System.out.println(st);
		}
		s.close();
		return students;
	}

	@Override
	public int addStudent(Student st) {
		Session s = HibernateUtil.getSession();
		Transaction t= s.beginTransaction();
		int result = (int)s.save(st);
		t.commit();
		s.close();
		return result;
	}

}
