package com.revature.beans;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component(value="author")
@Scope(value="prototype")
@Entity
@Table(name="AUTHOR")
public class Author implements Serializable {
	
	public Author(String firstname, String lastname) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
	}

	public Author() {
		super();
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="authorSequence")
	@SequenceGenerator(allocationSize=1,name="authorSequence",sequenceName="SQ_AUTHOR_PK")
	@Column(name="AUTHOR_ID")
	private int id;
	
	@Column(name="AUTHOR_FIRSTNAME")
	private String firstname;

	@Column(name="AUTHOR_LASTNAME")
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
	
}