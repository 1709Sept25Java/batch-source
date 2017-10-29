package exercise.dao;

import java.util.*;

import exercise.domain.*;

public interface FlashcardDao {

		public List<Flashcard> getFlashcards();
		
		public Flashcard getFlashcardById(int id);
		
		public int addFlashcard(Flashcard f);
		
		public void updateFlashcard (Flashcard f);
		
		public void deleteFlashcard(Flashcard f);
}
