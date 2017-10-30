package com.revature.dao;

import java.util.List;

import javax.transaction.Transaction;

import org.hibernate.Session;

import com.revature.domain.Flashcard;
import com.revature.domain.Student;
import com.revature.util.HibernateUtil;

public class FlashcardDaoImpl implements FlashcardDao {

	@Override
	public List<Flashcard> getFlashcards() {
		Session s = HibernateUtil.getSession();
		List<Flashcard> flashcards = s.createQuery("from Flashcard").list();
			for (Flashcard flashcard : flashcards) {
				System.out.println(s);
			}
		s.close();
	return flashcards;
	}

	@Override
	public Flashcard getFlashcard(int id) {
		Session s = HibernateUtil.getSession();
		Flashcard flashcard = (Flashcard) s.get(Flashcard.class, id);
		return flashcard;
	}

	@Override
	public int addFlashcard(Flashcard flashcard) {
		Session s = HibernateUtil.getSession();
		Transaction tx = (Transaction) s.beginTransaction();
		int result = 0;
		s.saveOrUpdate(flashcard);
		tx.commit();
		s.close();
		return result;
	}

	@Override
	public void deleteFlashcard(Flashcard flashcard) {
		Session s = HibernateUtil.getSession();
		Transaction tx = (Transaction) s.beginTransaction();
		s.delete(flashcard);
		tx.commit();
		s.close();
		
	}

	@Override
	public void updateFlashcard(Flashcard flashcard) {
		Session s = HibernateUtil.getSession();
		Transaction tx = (Transaction) s.beginTransaction();
		s.merge(flashcard);
		tx.commit();
		s.close();
		
	}

}
