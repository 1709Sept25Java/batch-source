package com.revature.beans;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component(value="bat")
@Scope(value="prototype")
public class Bat implements Serializable {
	
	public Bat(){
		super();
	}
	
	public Bat(String name, Cave cave) {
		this();
		this.name = name; 
		this.cave = cave;
	}
	
	private int id;
	
	private String name;

	@Autowired
	private Cave cave;

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

	public Cave getCave() {
		return cave;
	}

	public void setCave(Cave cave) {
		this.cave = cave;
	}
	
	@Override
	public String toString() {
		return "Bat [id=" + this.getId() + ", name=" + this.getName() + ", cave=" + this.getCave() + "]";
	}
}