package com.revature.domain;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="STUDENTS")

public class Student implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="studentIdSequence")
	@SequenceGenerator(allocationSize=1, name ="studentIdSequence")
	@Column(name="STUDENT_ID")
	private int id;
	
	@Column(name="FIRST")
	private String firstname;
	
	@Column(name="LAST")
	private String lastname;

	public Student(int id, String firstname, String lastname) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
	}

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

	@Override
	public String toString() {
		return "Student [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + "]";
	}
	
	
}
