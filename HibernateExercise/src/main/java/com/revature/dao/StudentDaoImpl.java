package com.revature.dao;

import java.util.List;

import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.Transaction;

import org.hibernate.Session;

import com.revature.domain.Student;
import com.revature.util.HibernateUtil;

public class StudentDaoImpl implements StudentDao {

	@Override
	public List<Student> getStudents() {
			Session s = HibernateUtil.getSession();
			List<Student> students = s.createQuery("from Student").list();
				for (Student student : students) {
					System.out.println(s);
				}
			s.close();
		return students;
	}

	@Override
	public Student getStudent(int id) {
		Session s = HibernateUtil.getSession();
		Student student = (Student) s.get(Student.class, id);
		return student;
	}

	@Override
	public int addStudent(Student student) {
		Session s = HibernateUtil.getSession();
		Transaction tx = (Transaction) s.beginTransaction();
		int result = 0;
		s.saveOrUpdate(student);
		tx.commit();
		s.close();
		return result;
	}

	@Override
	public void deleteStudent(Student student) {
		Session s = HibernateUtil.getSession();
		Transaction tx = (Transaction) s.beginTransaction();
		s.delete(student);
		tx.commit();
		s.close();
	}

	@Override
	public void updateStudent(Student student) {
		Session s = HibernateUtil.getSession();
		Transaction tx = (Transaction) s.beginTransaction();
		s.merge(student);
		tx.commit();
		s.close();
		
	}

}
