package com.dao;

import java.util.List;

import com.domain.Flashcard;

public interface FlashcardDao {

	public List<Flashcard> getFlashcard();
	public int addFlashcard(Flashcard fc);
}
