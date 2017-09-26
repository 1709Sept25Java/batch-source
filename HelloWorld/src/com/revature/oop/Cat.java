package com.revature.oop;

public class Cat extends Animal {

	static final int maxLives = 9;
	
	public void makeNoise() {
		System.out.println("meow");
	}

	//doesn't DO anything, but it does tell the compiler that this should
	//be an overridden method 
	@Override
	public String toString() {
		return "Cat []";
	}
}
