package com.revature.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.revature.domain.Flashcard;
import com.revature.domain.Student;
import com.revature.util.HibernateUtil;

public class FlashcardDaoImpl implements FlashcardDao{

	@Override
	public List<Flashcard> getFlashcards(int id) {
		
		Session session = HibernateUtil.getSession();
		List<Flashcard> flashcard = session.createQuery("from Flashcard").list();
		
		
		return flashcard;
	}

	@Override
	public void addFlashcard(String q, String ans, Student auth) {
		// TODO Auto-generated method stub
		
	}

}
