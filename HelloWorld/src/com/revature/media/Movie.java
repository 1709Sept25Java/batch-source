package com.revature.media;

import java.io.Serializable;

public class Movie extends Media implements Comparable<Movie>, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2488253115292646972L;

	public Movie() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Movie(String author, String title, int yearPublished, String genre) {
		super(author, title, yearPublished, genre);
		// TODO Auto-generated constructor stub
	}

	public void watch() {
		System.out.println("We're watching "+this.title);
	}

	@Override
	public int compareTo(Movie m) {
		//Alphabetical comparison of titles
		return this.title.compareTo(m.title);
	}
	
}
