package com.revature.media;

import java.io.Serializable;

public class Movie extends Media implements Comparable<Movie>, Serializable{
	private static final long serialVersionUID = -8232955013119782695L;
	public Movie() {

		super();


	}
	public Movie(String author, String title, int yearPublished, String genre) {
		super(author, title, yearPublished, genre);
		// TODO Auto-generated constructor stub
	}

	public void watch() {
		System.out.println("get your popcorn! we're watching" + this.title);
	}

	@Override
	public String toString() {
		return "Movie [author=" + author + ", title=" + title + ", yearPublished=" + yearPublished + ", genre=" + genre
				+ "]";
	}
	@Override
	public int compareTo(Movie m) {
		return this.title.compareTo(m.title);
	}
}
