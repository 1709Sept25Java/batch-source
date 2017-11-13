package com.revature.beans;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component(value="book")
@Scope(value="prototype")
@XmlRootElement
@Entity
@Table(name="BOOK")
public class Book {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="bookSequence")
	@SequenceGenerator(allocationSize=1,name="bookSequence",sequenceName="SQ_BOOK_PK")
	@Column(name="BOOK_ID")
	private int id;
	
	@Column(name="TITLE")
	private String title;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "AUTHOR_ID")
	private Author author;

	public Book() {
		super();
	}

	public Book(int id, String title, Author author) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + "]";
	}
	
	@XmlElement
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@XmlElement
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	@XmlElement
	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}
	
	
	
	
}
