package com.revature.dao;

import java.util.List;

import com.revature.domain.Flashcard;
import com.revature.domain.Student;

public interface FlashcardDao {

	List<Flashcard> getFlashcards(int id);
	
	void addFlashcard(String q,String ans,Student auth);
	
}
