package exercise.dao;

import java.util.List;

import org.hibernate.*;

import exercise.domain.*;
import exercise.util.*;

public class StudentDaoImpl implements StudentDao{

	@Override
	public List<Student> getStudents() {
		Session s = HibernateUtil.getSession();
		List<Student> students = s.createQuery("from STUDENT").list();
		s.close();
		return students;
	}

	@Override
	public Student getStudentById(int id) {
		Session s = HibernateUtil.getSession();
		Student st = (Student) s.get(Student.class, id);
		s.close();
		return st;
	}

	@Override
	public int addStudent(Student st) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		int result = 0;
		s.saveOrUpdate(st);
		tx.commit();
		s.close();
		return result;
	}

	@Override
	public void updateStudent(Student st) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		s.merge(st);
		tx.commit();
		s.close();
		
	}

	@Override
	public void deleteStudent(Student st) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		s.delete(st);
		tx.commit();
		s.close();
	}

	
}
