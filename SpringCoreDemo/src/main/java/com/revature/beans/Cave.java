package com.revature.beans;

public class Cave {

	private int id;
	private String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Cave(){
		super();
	}

	@Override
	public String toString() {
		return "Cave [id=" + id + ", name=" + name + "]";
	}

}
