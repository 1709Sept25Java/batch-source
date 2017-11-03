package com.revature.beans;

import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

@Component(value="cave")
public class Cave {
	
	@NotNull(message="please enter an id") //also @Max, @Min, @Past, @DateTime, @Future, @AssertTrue, @AssertFalse, etc. 
	private int id;
	@NotNull(message="please enter a name")
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

}
