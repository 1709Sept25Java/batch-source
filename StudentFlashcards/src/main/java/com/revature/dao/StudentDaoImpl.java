package com.revature.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.domain.Student;
import com.revature.util.HibernateUtil;

public class StudentDaoImpl implements StudentDao {

	public List<Student> getStudents() {
		Session session = HibernateUtil.getSession();
		List<Student> students = session.createQuery("from Student").list();
		session.close();
		return students;
	}

	public Student getStudentById(int id) {
		Session session = HibernateUtil.getSession();
		Student s = (Student) session.get(Student.class, id);
		session.close();
		return s;
	}

	public int addStudent(Student s) {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		int result = (Integer) session.save(s);
		tx.commit();
		session.close();
		return result;
	}

	public void updateStudent(Student s) {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		session.merge(s);
		tx.commit();
		session.close();
	}



}
