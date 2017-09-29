package com.revature.media;

public class Movie extends Media{

		public void watch() {
			System.out.println("Get your popcorn ready!");
		}


		public Movie() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Movie(String authour, String title, String yearsPublished, String genre) {
			super(authour, title, yearsPublished, genre);
			// TODO Auto-generated constructor stub
		}
}
