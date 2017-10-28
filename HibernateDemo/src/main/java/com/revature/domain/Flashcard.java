package com.revature.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

public class Flashcard implements Serializable {

	private static final long serialVersionUID = 1L;
	//Flashcard - with int id, String question, String answer, Student author
	public Flashcard() {
		super();
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="flashcardSequence")
	@SequenceGenerator(allocationSize=1,name="flashcardSequence",sequenceName="SQ_FLASHCARD_PK")
	@Column(name="FLASHCARD_ID")
	private int id;
	@Column(name="QUESTION")
	private String question;
	@Column(name="ANSWER")
	private String answer;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="AUTHOR_ID")
	private Student author;
	
	public Flashcard(int id, String question, String answer, Student author) {
		this.id=id;
		this.question=question;
		this.answer=answer;
		this.author=author; 
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
	
	public Student getStudent() {
		return author;
	}
	
	public void setStudent(Student author) {
		this.author=author;
	}
	
	@Override
	public String toString() {
		return "Flashcard [id=" + id + ", question=" + question + ", answer=" + answer + ", author="+ author+",]";
	}
	
}
