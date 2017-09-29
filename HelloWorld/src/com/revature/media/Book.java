package com.revature.media;

public class Book extends Media {
	
	private String publisher;
	
	public Book() {
		super();
	}

	public Book(String author, String title, int yearPublished, String genre) {
		super(author, title, yearPublished, genre);
	}

	public void read() {
		System.out.println("reading "+this.title+" by "+this.author);
	}

	@Override
	public String toString() {
		return "Book [publisher=" + publisher + ", author=" + author + ", title=" + title + ", yearPublished="
				+ yearPublished + ", genre=" + genre + "]";
	}

	
}
