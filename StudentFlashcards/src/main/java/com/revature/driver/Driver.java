package com.revature.driver;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.revature.dao.FlashcardDao;
import com.revature.dao.FlashcardDaoImpl;
import com.revature.dao.StudentDao;
import com.revature.dao.StudentDaoImpl;
import com.revature.domain.Flashcard;
import com.revature.domain.Student;
import com.revature.util.HibernateUtil;

public class Driver {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSession();
		
		StudentDao sd = new StudentDaoImpl();
		Student s1 = new Student(1000, "Abigail","Pie");
		Student s2 = new Student(1002, "Brenda","Maybe");
		Student s3 = new Student(1004, "A","Mazing");
		Student s4 = new Student(1006, "Giselle","Mae");
		sd.addStudent(s1);
		sd.addStudent(s2);
		sd.addStudent(s3);
		sd.addStudent(s4);
		
		FlashcardDao fd = new FlashcardDaoImpl();
		Flashcard f1 = new Flashcard(3000, "Math Operations?","+ - * /", s1);
		Flashcard f2 = new Flashcard(3003, "Vowels?","AEIOU", s1);
		fd.addFlashcard(f1);
		fd.addFlashcard(f2);
		
//		Write a named query to retrieve the first three Flashcards which belong to a student.
		Query q = session.getNamedQuery("findFlashcardsByStudent");
		q.setInteger("id", s1.getId());
		List<Flashcard> flashcards = q.list();
		System.out.println(flashcards.size());
		Iterator<Flashcard> itr = flashcards.iterator();
		while(itr.hasNext()){
			System.out.println(itr.next());
		}
		
//		Write criteria to return a list in descending order of all students who have last names that start with “M”. 
		List<Student> mStudents = session.createCriteria(Student.class).add(Restrictions.ilike("lastName", "m%")).addOrder(Order.asc("firstName")).list();
		for (Student s : mStudents){
			System.out.println(s);
		}
		session.close();
	}
	

}