package com.revature.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.domain.Flashcard;
import com.revature.domain.Student;
import com.revature.util.HibernateUtil;

public class FlashcardDaoImpl implements FlashcardDao{

	@Override
	public List<Flashcard> getFlashcards() {
		
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		List<Flashcard> flashcards = session.createQuery("from Flashcard").list();
		
		for(Flashcard f : flashcards) {
			System.out.println(f);
		}
		
		tx.commit();
		session.close();
		return flashcards;
	}

	@Override
	public int addFlashcard(Flashcard f) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		
		int result = (int)s.save(f);
		
		tx.commit();
		s.close();
		return result;
	}

}
