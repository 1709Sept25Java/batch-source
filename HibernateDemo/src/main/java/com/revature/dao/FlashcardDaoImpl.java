package com.revature.dao;

import java.util.List;

import org.hibernate.Session;

import com.revature.domain.Flashcard;
import com.revature.util.HibernateUtil;

public class FlashcardDaoImpl implements FlashcardDao{

	@Override
	public List<Flashcard> getFlashcards() {
		Session s = HibernateUtil.getSession();
		List<Flashcard> flashcard = s.createQuery("from Flashcard").list();
			for(Flashcard f : flashcard){
				System.out.println(f);
			}
		s.close();
		return flashcard;
	}

	@Override
	public Flashcard getFlashcardById(int id) {
		Session s = HibernateUtil.getSession();
		Flashcard f = (Flashcard) s.get(Flashcard.class, id); 
		s.close();
		return f;
	}

	@Override
	public int addFlashcard(Flashcard f) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void updateFlashcard(Flashcard f) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteFlashcard(Flashcard f) {
		// TODO Auto-generated method stub
		
	}

}
