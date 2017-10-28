package com.revature.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

public class Student implements Serializable {
	//Student - with int id, String firstname, String lastname
	
	private static final long serialVersionUID = 1L;

	public Student() {
		super();
	}
	
	public Student(int id, String firstname, String lastname) {
		this.id=id;
		this.firstname=firstname;
		this.lastname=lastname;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="studentSequence")
	@SequenceGenerator(allocationSize=1,name="studentSequence",sequenceName="SQ_STUDENT_PK")
	@Column(name="STUDENT_ID")
	private int id;
	
	@Column(name="F_NAME")
	private String firstname;
	@Column(name="L_NAME")
	private String lastname;
	
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
		return "Student [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ",]";
	}
}
