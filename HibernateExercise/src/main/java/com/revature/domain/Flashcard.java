package com.revature.domain;

import java.io.Serializable;

import javax.persistence.*;

@NamedQueries({@NamedQuery(name="getStudentFlashcards",query="from Flashcard where author=:studentVar")})
@Entity
@Table(name="FLASHCARD")
public class Flashcard implements Serializable{

	public Flashcard(int id, String question, String answer, Student author) {
		super();
		this.id = id;
		this.question = question;
		this.answer = answer;
		this.author = author;
	}

	public Flashcard(String question, String answer, Student author) {
		super();
		this.question = question;
		this.answer = answer;
		this.author = author;
	}

	public Flashcard() {
		super();
	}

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seqFlashcard")
	@SequenceGenerator(allocationSize=1,name="seqFlashcard",sequenceName="SQ_FLASHCARD")
	@Column(name="FC_ID")
	private int id;
	
	@Column(name="FC_QUESTION")
	private String question;
	
	@Column(name="FC_ANSWER")
	private String answer;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="FC_AUTHOR")
	private Student author;

	public int getId() {
		return id;
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
