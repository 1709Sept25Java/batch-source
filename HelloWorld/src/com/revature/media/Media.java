package com.revature.media;

public abstract class Media {
	
	protected String authour;
	
	protected String title;
	
	protected String yearsPublished;
	
	protected String genre;

	public String getAuthour() {
		return authour;
	}

	public void setAuthour(String authour) {
		this.authour = authour;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getYearsPublished() {
		return yearsPublished;
	}

	public void setYearsPublished(String yearsPublished) {
		this.yearsPublished = yearsPublished;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public Media(String authour, String title, String yearsPublished, String genre) {
		super();
		this.authour = authour;
		this.title = title;
		this.yearsPublished = yearsPublished;
		this.genre = genre;
	}

	public Media() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
