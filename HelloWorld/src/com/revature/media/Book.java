package com.revature.media;

public class Book extends Media{

	public void read() {
		System.out.println("reading " + this.title + " by " + this.authour);
	}

	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Book(String authour, String title, String yearsPublished, String genre) {
		super(authour, title, yearsPublished, genre);
		// TODO Auto-generated constructor stub
	}
}
