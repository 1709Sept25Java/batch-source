package com.revature.driver;

import org.hibernate.Session;

import com.revature.dao.*;
import com.revature.domain.*;
import com.revature.util.HibernateUtil;

public class Driver {

	public static void main(String[] args) {
		
		FlashcardDao fd = new FlashcardDaoImpl();
		StudentDao sd = new StudentDaoImpl();
		
		Student s = new Student("Sally","Brown");
		Flashcard f = new Flashcard("why are you telling me?","philosophy",s);
		
		sd.addStudent(s);
		fd.addFlashcard(f);
		
		sd.getStudent();
		fd.getFlashcards();
		
	} 
	
}
