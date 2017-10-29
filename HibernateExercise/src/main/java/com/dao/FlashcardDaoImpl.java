package com.dao;

import java.util.List;

import javax.transaction.Transaction;

import org.hibernate.Session;

import com.domain.Flashcard;
import com.util.HibernateUtil;


public class FlashcardDaoImpl implements FlashcardDao{

	@Override
	public List<Flashcard> getFlashcard() {
		Session s = HibernateUtil.getSession();
		List<Flashcard> flashcard = s.createQuery("from Flashcard").list();
		for(Flashcard fc: flashcard) {
			System.out.println(fc);
		}
		s.close();
		return flashcard;
	}

	@Override
	public int addFlashcard(Flashcard fc) {
		Session s = HibernateUtil.getSession();
		//Transaction tx=s.beginTransaction();
		int result = (int) s.save(fc);
		//tx.commit();
		s.close();
		return result;
		
	}

}
