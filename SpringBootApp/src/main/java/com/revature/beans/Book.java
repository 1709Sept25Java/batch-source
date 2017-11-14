package com.revature.beans;

import java.io.Serializable;

import javax.persistence.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component(value="book")
@Scope(value="prototype")
@Entity
@Table(name="BOOK")
public class Book implements Serializable{

	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Book(String title, Author author) {
		super();
		this.title = title;
		this.author = author;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="bookSequence")
	@SequenceGenerator(allocationSize=1,name="bookSequence",sequenceName="SQ_BOOK_PK")
	private int id;
	@Column(name="title")
	private String title;
	@ManyToOne(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="AUTHOR")
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
	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + "]";
	}
}