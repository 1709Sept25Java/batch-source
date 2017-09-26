package com.revature.oop;

public class Cat extends Animal{

	public Cat() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cat(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	
	public static int maxLives = 9;
	
	public void makeNoise(){
		System.out.println("meow");
	}

}
