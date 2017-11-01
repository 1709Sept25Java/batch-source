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
	
	public void defaultInit() {
		System.out.println("default init from Cave");
	}
	
	public void defaultDestroy() {
		System.out.println("default destroy from Cave");
	}

}