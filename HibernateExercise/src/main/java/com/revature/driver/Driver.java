package com.revature.driver;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.revature.dao.*;
import com.revature.domain.*;
import com.revature.util.HibernateUtil;

public class Driver {

	public static void main(String[] args) {
		
		//partOne();
		
		//partTwoNamedQuery();
		
		partTwoCriteria();
		
		
	} 
	
	public static void partOne() {
		
		FlashcardDao fd = new FlashcardDaoImpl();
		StudentDao sd = new StudentDaoImpl();
		
		Student s = new Student("Sally","Brown");
		Flashcard f = new Flashcard("why are you telling me?","philosophy",s);
		
		sd.addStudent(s);
		fd.addFlashcard(f);
		
		sd.getStudent();
		fd.getFlashcards();
	}
	
	public static void partTwoNamedQuery() {
		/*	
		Student s = new Student("Lucy","van Pelt");
		Flashcard f1 = new Flashcard("fir tree","it gives us fur for coats",s);
		Flashcard f2 = new Flashcard("bugs","they make the grass grow",s);
		Flashcard f3 = new Flashcard("stars and planets","make the rain",s);
		Flashcard f4 = new Flashcard("winter","snow comes up like flowers",s);
		Flashcard f5 = new Flashcard("clouds","make the wind blow",s);
		
		FlashcardDao fd = new FlashcardDaoImpl();
		StudentDao sd = new StudentDaoImpl();
		
		sd.addStudent(s);
		fd.addFlashcard(f1);
		fd.addFlashcard(f2);
		fd.addFlashcard(f3);
		fd.addFlashcard(f4);
		fd.addFlashcard(f5);	*/
		
		Session session = HibernateUtil.getSession();
		
		
		Query q = session.getNamedQuery("getStudentFlashcards");
		q.setInteger("studentVar", 21);
		
		List<Flashcard> flashcards = q.setMaxResults(3).list();
		
		for(Flashcard f : flashcards) {
			System.out.println(f);
		}
		
		session.close();
	}
	
	public static void partTwoCriteria() {
		/*
		Student s1 = new Student("Kel","Mindalin");
		Student s2 = new Student("Matry","McFly");
		StudentDao sd = new StudentDaoImpl();
		sd.addStudent(s1);
		sd.addStudent(s2);
		*/
		Session session = HibernateUtil.getSession();
		
		Criteria c = session.createCriteria(Student.class).add(Restrictions.like("lastname", "M%"));
		List<Student> students = c.list();
		
		for(Student s : students) {
			System.out.println(s);
		}
		
		session.close();
	}
}
