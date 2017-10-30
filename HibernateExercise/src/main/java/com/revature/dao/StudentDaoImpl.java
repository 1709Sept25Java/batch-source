package com.revature.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.domain.Student;
import com.revature.util.HibernateUtil;

public class StudentDaoImpl implements StudentDao{

	@Override
	public List<Student> getStudent() {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		List<Student> students = session.createQuery("from Student").list();
		System.out.println();
		for(Student s : students) {
			System.out.println(s);
		}
		
		
		tx.commit();
		session.close();
		return null;
	}

	@Override
	public int addStudent(Student s) {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		int result = (int)session.save(s);
		
		tx.commit();
		session.close();
		return result;
	}

}
