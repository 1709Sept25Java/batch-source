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
public class Author implements Serializable{

	public Author() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Author(int id, String firstname, String lastname) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
	}
	public Author(String firstname, String lastname, List<Book> book) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="authorSequence")
	@SequenceGenerator(allocationSize=1,name="authorSequence",sequenceName="SQ_AUTHOR_PK")
	@Column(name="ID")
	private int id;
	@Column(name="firstname")
	private String firstname;
	@Column(name="lastname")
	private String lastname;
	@OneToMany(mappedBy="author", fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	private List<Book> book;
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
		return "Author [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + "]";
	}
	
}
