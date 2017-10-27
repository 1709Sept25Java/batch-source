package com.revature.dao;

import java.util.List;

import com.revature.domain.Flashcard;
import com.revature.domain.Student;

public interface FlashcardDao {

	public List<Flashcard> getFlashcards();
	
	public int addFlashcard(Flashcard f);
	
}
