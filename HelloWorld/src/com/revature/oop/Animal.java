package com.revature.oop;

public class Animal {
	// few fields and implement behaviors 
	// bean/POJO (plain old java object) 
	
	//constructor is used to create new instances of Animal
	
	public Animal() { //with no arg
		super();
	}
	
	public Animal(String name) {
		super();
		this.name = name;
	}
	// setters and getters allows other classes to interact 

	private String name;
	
	public String getName() { // instance method to retrieve private field "name" 
		//"accessor" or getter methods 
		return this.name; // best practices  to refer to current Animal object 
	}
	
	// instance methods to set private field "name"
	//"mutaror" or "setter method"
	public void setName(String name) { //type string, identifier name
		this.name = name;
	}

	public void makeNoise() {
		System.out.println("generic noise");
	}
	
	
	
}
