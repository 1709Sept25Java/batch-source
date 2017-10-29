package com.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "STUDENT")
public class Student implements Serializable {

	public Student() {
		super();
	}

	public Student(String firstname, String lastname) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
	}

	public Student(int id, String firstname, String lastname) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="studentSequence")
	@SequenceGenerator(allocationSize=1,name="studentSequence",sequenceName="SQ_STUDENT_PK")
	@Column(name="STUDENT_ID")
	private int id;
	@Column(name="FIRSTNAME")
	private String firstname;
	@Column(name="LASTNAME")
	private String lastname;
	
	@OneToMany(mappedBy="student",fetch=FetchType.LAZY)
	private List<Flashcard> flashcards;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "Student [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + "]";
	}
}
