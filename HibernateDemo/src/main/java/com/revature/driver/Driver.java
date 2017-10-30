package com.revature.driver;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.domain.*;
import com.revature.util.HibernateUtil;

import com.revature.dao.*;

public class Driver {

	public static void main(String[] args) {
		init();
		StudentDaoImpl stdi= new StudentDaoImpl();
		FlashcardDaoImpl fli= new FlashcardDaoImpl();
		
		//get v load
		/*
		if (bd.getBatById(2) != null) {
			System.out.println("bat 2 exists");
		} else {
			System.out.println("bat 2 does not exist");
		}
		System.out.println(bd.getBatById(2));
		*/
		
		//save
		System.out.println(stdi.addStudent(new Student("first","second")));
		//System.out.println(fli.addFlashcard(new Flashcard("question1","answer1",stdt)));
		
		//update
		Student stdt= new Student("first","second");
		stdi.updateStudent(stdt);
			
	}

	static void init() {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		
		//create transient objects	
		Student std= new Student("first","second");
		Flashcard fl= new Flashcard("question1","answer1", std);
		
		//persist them, and print out generated identifiers
		System.out.println(s.save(std));
		System.out.println(s.save(fl));
		
		tx.commit();
		System.out.println("finished tx");
		s.close();
		
	}

}
