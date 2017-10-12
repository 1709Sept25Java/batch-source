package com.revature.domain;

public class Cave {

	public Cave(String name, int maxBears) {

		super();

		this.name = name;

		this.maxBears = maxBears;

	}
	public Cave(int id, String name, int maxBears) {
		super();
		this.id = id;
		this.name = name;
		this.maxBears = maxBears;
	}
	public Cave() {
		super();
		// TODO Auto-generated constructor stub
	}
	private int id;
	private String name;
	private int maxBears;
	public int getid() {
		return id;
	}
	public void setid(int id) {
		id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMaxBears() {
		return maxBears;
	}
	public void setMaxBears(int maxBears) {
		this.maxBears = maxBears;
	}
	@Override
	public String toString() {
		return "Cave [Id=" + id + ", name=" + name + ", maxBears=" + maxBears + "]";
	}
}
