package com.revature.servlet;

public class Country {
	private String name;
	private String capital;
	public Country() {
		super();
	}
	
	public Country(String n, String c) {
		this.name = n;
		this.capital = c;
	}
	
	@Override
	public String toString() {
		return "Country [name=" + name + ", capital=" + capital + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCapital() {
		return capital;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}

}
