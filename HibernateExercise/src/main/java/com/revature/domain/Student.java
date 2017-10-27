package com.revature.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="STUDENT")
public class Student implements Serializable{

	public Student(int id, String firstname, String lastname, List<Flashcard> flashcards) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.flashcards = flashcards;
	}

	public Student(String firstname, String lastname, List<Flashcard> flashcards) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.flashcards = flashcards;
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seqStudent")
	@SequenceGenerator(allocationSize=1,name="seqStudent",sequenceName="SQ_STUDENT")
	@Column(name="S_ID")
	int id;
	
	@Column(name="S_FNAME")
	String firstname;
	
	@Column(name="S_LNAME")
	String lastname;
	
	@OneToMany(mappedBy="author",fetch=FetchType.EAGER)
	List<Flashcard> flashcards;

	public int getId() {
		return id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public List<Flashcard> getFlashcards() {
		return flashcards;
	}

	public void setFlashcards(List<Flashcard> flashcards) {
		this.flashcards = flashcards;
	}
	
}
