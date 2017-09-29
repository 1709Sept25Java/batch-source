package com.revature.media;

public class Movie extends Media {
	
	public Movie() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Movie(String author, String title, int yearPublished, String genre) {
		super(author, title, yearPublished, genre);
		// TODO Auto-generated constructor stub
	}

	public void watch(){
		System.out.println("get your popcorn! We're watching "+this.title);
	}

	@Override
	public String toString() {
		return "Movie [author=" + author + ", title=" + title + ", yearPublished=" + yearPublished + ", genre=" + genre
				+ "]";
	}

}
