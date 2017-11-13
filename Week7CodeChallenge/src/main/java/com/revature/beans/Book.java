package com.revature.beans;

public class Book {
	
	public Book(){
		super();
	}
	
	public Book(int id, String title, String author) {
		super();
		this.id=id;
		this.title = title;
		this.author = author;
	}
	private int id;
	private String title;
	private String author;
	private int year;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return "Book [id= "+ id +"title=" + title + ", author=" + author+ "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
