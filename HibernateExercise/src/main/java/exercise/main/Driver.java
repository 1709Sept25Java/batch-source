package exercise.main;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import exercise.dao.*;
import exercise.domain.*;
import exercise.util.HibernateUtil;

public class Driver {

	public static void main(String[] args) {
		
		//add students to table
		StudentDao sd = new StudentDaoImpl();
		FlashcardDao fd = new FlashcardDaoImpl();
		
		//System.out.println(sd.addStudent(new Student("Jane", "Doe")));
		//System.out.println(sd.addStudent(new Student("John", "Miller")));
		//System.out.println(sd.addStudent(new Student("Bob", "Monroe")));
		
		Student s1 = sd.getStudentById(1);
		Student s2 = sd.getStudentById(2);
		
		//add flashcards to table
		/*
		System.out.println(fd.addFlashcard(new Flashcard("Who was the first president for U.S.A?", "George Washington", s1)));
		System.out.println(fd.addFlashcard(new Flashcard("What two colors do you mix to get purple?", "Red and blue", s1)));
		System.out.println(fd.addFlashcard(new Flashcard("How many seconds are in a minute?", "60 seconds", s1)));
		System.out.println(fd.addFlashcard(new Flashcard("How many states are in the U.S.A?", "50 states", s2)));
		*/
		
		executeNamedQuery(s1);
		lastNameMCriteria();
		
	}
	//Write a named query to retrieve the first three Flashcards which belong to a student.
	static void executeNamedQuery(Student st) {
		Session s = HibernateUtil.getSession();
		Query q = s.getNamedQuery("firstThreeFlashcardByStudent");
		q.setInteger("id", st.getId()); 
		List<Flashcard> flashcards = q.list();
		Iterator<Flashcard> itr = flashcards.iterator();
		for(int i = 0; i < 3; i++) {
			System.out.println(itr.next());
		}
		s.close();
	}
	
	//Write criteria to return a list in descending order of all students who have last names that start with “M”. 
	static void lastNameMCriteria() {
		Session s = HibernateUtil.getSession();
		
		List<Student> studentLastnameM = s.createCriteria(Student.class).add(Restrictions.like("lastname", "M%")).addOrder(Order.desc("firstname")).list();
		for( Student st : studentLastnameM) {
			System.out.println(st);
		}
		
		s.close();
	}

}