package com.revature.oop;

public class Animal {

	//This is a "POJO" (plain old java object) or "bean"
	private String name;
	
	
	//Constructor is used to create new instance of Animal
	
	public Animal() {
		super();
	}
	
	public Animal(String name) {
		super();
		this.name = name;
	}
	
	//Instance method to retrieve private field "name"
	//"Accesor" or "getter method"
	public String getName() {
		return this.name; //best practice to use "this" to refer to current Animal Object
	}
	
	//Instance method to set private field "name"
	//"Mutator" or "setter method"
	public void setName(String name) {
		this.name = name;
	}
	
	public void makeNoise() {
		System.out.println("generic noise");
	}
	
	@Override //doesn't DO anything but it does tell the compiler that this 
	//should be an overrident method
	public String toString() {
		return "Animal [name=" + name + "]";
	}
}
