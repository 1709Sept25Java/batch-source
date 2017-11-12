package com.revature.beans;

import java.util.List;

import javax.persistence.*;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component(value="author")
@Scope(value="prototype")
@Entity
@Table(name="AUTHOR")
public class Author {
	
	public Author() {
		super();
	}

	public Author(int id, String firstName, String lastName, List<Book> books) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.books = books;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="authorSequence")
	@SequenceGenerator(allocationSize=1,name="authorSequence",sequenceName="SQ_AUTHOR_PK")
	@Column(name="A_ID")
	private int id;
	
	@Column(name="A_FIRST_NAME")
	private String firstName;
	
	@Column(name="A_LAST_NAME")
	private String lastName;
	
	@OneToMany(mappedBy="author",fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	private List<Book> books;

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

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	@Override
	public String toString() {
		return "Author [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}
	
}
