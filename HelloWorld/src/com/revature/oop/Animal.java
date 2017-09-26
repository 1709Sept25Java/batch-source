package com.revature.oop;

public class Animal {

	public Animal() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Animal(String name) {
		super();
		this.name = name;
	}

	//this is a POJO (plain old java object) or 'bean'

	private String name;
	
	//instance method to retrieve private field "name"
	//"accessor" or "getter method"
	public String getName() {
		return this.name; //best practices to refer to current Animal object
	}
	
	//instance method to set private field "name"
	//"mutator" or "setter method"
	public void setName(String name) {
		this.name = name;
	}
	
	public void makeNoise() {
		System.out.println("generic noise");
	}

	//doesn't DO anything, but it does tell the compiler that this should
	//be an overridden method
	@Override
	public String toString() {
		return "Animal [name=" + name + "]";
	}
}
