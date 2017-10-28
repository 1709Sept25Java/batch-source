package com.revature.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.domain.Flashcard;
import com.revature.util.HibernateUtil;

public class FlashcardDaoImpl implements FlashcardDao{


	public List<Flashcard> getFlashcards() {
		Session session = HibernateUtil.getSession();
		List<Flashcard> flashcards = session.createQuery("from Flashcard").list();
		session.close();
		return flashcards;
	}

	public Flashcard getFlashcardById(int id) {
		Session session = HibernateUtil.getSession();
		Flashcard f = (Flashcard) session.get(Flashcard.class, id);
		session.close();
		return f;
	}

	public int addFlashcard(Flashcard f) {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		int result = (Integer) session.save(f);
		tx.commit();
		session.close();
		return result;
	}

	public void updateFlashcard(Flashcard f) {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		session.merge(f);
		tx.commit();
		session.close();		
	}
	
	




}
