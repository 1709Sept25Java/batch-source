package com.revature.media;

public class Book extends Media {
	
	private String publisher;
	
	public Book() {
		super();
	}

	public Book(String author, String title, int i, String genre) {
		super(author, title, i, genre);
	}

	public void read(){
		System.out.println("reading "+this.title+" by "+this.author);
	}

	@Override
	public String toString() {
		return "Book [author=" + author + ", title=" + title + ", yearPublished=" + yearPublished + ", genre=" + genre
				+ ", publisher=" + publisher+"]";
	}

}