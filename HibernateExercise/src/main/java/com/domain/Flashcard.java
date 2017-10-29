package com.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "FLASHCARD")
public class Flashcard implements Serializable {
	public Flashcard() {
		super();
	}

	//@OneToMany
	public Flashcard(String question, String answer, Student student) {
		super();
		this.question = question;
		this.answer = answer;
		this.student = student;
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
	@JoinColumn(name="AUTHOR")
	private Student student;

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
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "Flashcard [id=" + id + ", question=" + question + ", answer=" + answer + ", student=" + student + "]";
	}

	

}
