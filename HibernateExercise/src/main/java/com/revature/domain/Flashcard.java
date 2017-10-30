package com.revature.domain;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "FLASHCARDS")

public class Flashcard implements Serializable{
	@Id
	@GeneratedValue(strategy  = GenerationType.SEQUENCE, generator ="flashcardIdSequence")
	@SequenceGenerator(allocationSize=1, name ="flashcardIdSequence")
	@Column(name = "FLASHCARD_ID")
	private int id;
	
	@Column(name = "QUESTION")
	private String question;
	
	@Column(name = "ANSWER")
	private String answer;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn (name="STUDENT_ID")
	private Student author;

	public Flashcard(int id, String question, String answer, Student author) {
		super();
		this.id = id;
		this.question = question;
		this.answer = answer;
		this.author = author;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public Student getAuthor() {
		return author;
	}

	public void setAuthor(Student author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "Flashcard [id=" + id + ", question=" + question + ", answer=" + answer + ", author=" + author + "]";
	}

}
