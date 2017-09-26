package com.revature.oop;

public class Cat extends Animal{
	
	public static int maxLives = 9;
	
	public Cat() {
		super();
	}

	public Cat(String name) {
		super(name);
	}

	public void makeNoise() {
		System.out.println("meow");
	}

}
