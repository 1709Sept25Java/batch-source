package com.revature.media;

public class Book extends Media {

		public void read() {
			System.out.println("Reading "+this.title+" by "+this.author);
		}

		
		public Book(String author, String title, String genre, int yearPublished) {
			super(author, title, genre, yearPublished);
			// TODO Auto-generated constructor stub
		}

		public Book() {
			super();
		}

		@Override
		public String toString() {
			return "Book [author=" + author + ", title=" + title + ", genre=" + genre + ", yearPublished="
					+ yearPublished + "]";
		}
		
}
