package exercise.dao;

import java.util.List;

import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;

import org.hibernate.Session;
import org.hibernate.Transaction;

import exercise.domain.Flashcard;
import exercise.util.HibernateUtil;

public class FlashcardDaoImpl implements FlashcardDao {

	@Override
	public List<Flashcard> getFlashcards() {
		Session s = HibernateUtil.getSession();
		List<Flashcard> flashcards = s.createQuery("from Flashcard").list();
		s.close();
		return flashcards;
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
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		int result = 0; 
		s.saveOrUpdate(f);
		tx.commit();
		s.close();
		return result;
	}

	@Override
	public void updateFlashcard(Flashcard f) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		s.merge(f);
		tx.commit();
		s.close();
	}

	@Override
	public void deleteFlashcard(Flashcard f) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		s.delete(f);
		tx.commit();
		s.close();
		
	}

}
