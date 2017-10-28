package com.revature.driver;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.revature.domain.Flashcard;
import com.revature.util.HibernateUtil;

public class Driver {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSession();
		System.out.println(session.getStatistics());
		//session.createCriteria(Flashcard.class).add(Restrictions.eq("student.student_id",studentid))
	}
	
//	Write a named query to retrieve the first three Flashcards which belong to a student.
//	Write criteria to return a list in descending order of all students who have last names that start with “M”. 

}