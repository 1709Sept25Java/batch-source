package com.revature.oop;

public class Animal {
	//this is a "POJO" (plain old java object) or "bean"
	
	//constructor is used to create new instances of Animal
	
	public Animal(String name) {
		super();
	}
	public Animal(String name) {
		super();
		this.name = name;
	}
	
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
	
	//can go to source tab and auto create setter/getter/constructor
	
	public void makeNoise() {
		System.out.println("make noise");
	}
	@Override
	public String toString() {
		return "Animal [name=" + name + "]";
	}
}
