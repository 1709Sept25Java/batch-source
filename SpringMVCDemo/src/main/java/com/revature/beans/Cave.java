package com.revature.beans;

import org.springframework.stereotype.Component;

@Component(value="cave")
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
	
}