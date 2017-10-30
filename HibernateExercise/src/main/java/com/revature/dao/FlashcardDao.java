package com.revature.dao;

import java.util.List;

import com.revature.domain.*;

public interface FlashcardDao {

	public List<Flashcard> getFlashcards();
	public Flashcard getFlashcard(int id);
	public int addFlashcard(Flashcard flashcard);
	public void deleteFlashcard(Flashcard flashcard);
	public void updateFlashcard(Flashcard flashcard);
}
