package com.revature.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="STUDENT")
public class Student implements Serializable {

	public Student(int id, String firstName, String lastName) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public Student() {
		super();
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="studentSequence")
	@SequenceGenerator(allocationSize=1,name="studentSequence",sequenceName="SQ_STUDENT_PK")
	@Column(name="STUDENT_ID")
	private int id;
	
	@Column(name="STUDENT_FIRSTNAME")
	private String firstName;
	
	@Column(name="STUDENT_LASTNAME")
	private String lastName;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}
	
	

}
