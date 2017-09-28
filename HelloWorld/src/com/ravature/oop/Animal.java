package com.ravature.oop;

public class Animal {
	//this is "POJO" (plain old java object) or 'bean'
	
	//constructor is used to create new instance of animal
	public Animal() {
		super();
	}
	
	private String name;
	
	//instance method to retrieve private field "name"
	//"accessor" or "getter method"
	public String getName(){
		return this.name; //best practice to refer to current animal object
	}
	
	//instance method to set private field "name"
	public void setName(String name) {
		this.name = name;
		
		publuic void makeNoise() {
			System.out.println
		}
	}

}
