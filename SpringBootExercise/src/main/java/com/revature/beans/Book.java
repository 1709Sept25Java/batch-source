package com.revature.beans;

import java.io.Serializable;

import javax.persistence.*;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component(value="book")
@Scope(value="prototype")
@Entity
@Table(name="BOOK")
public class Book implements Serializable{

	public Book() {
		super();
	}
	
	public Book(int id, String title, Author author) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="bookSequence")
	@SequenceGenerator(allocationSize=1,name="bookSequence",sequenceName="SQ_BOOK_PK")
	@Column(name="B_ID")
	private int id;
	
	@Column(name="B_TITLE")
	private String title;
	
	@ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name="B_AUTHOR")
	private Author author;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Author getAuthor() {
		return author;
	}
	public void setAuthor(Author author) {
		this.author = author;
	}
	
}
