package com.revature.oop;

public class Dog extends Animal{
	public Dog() {
		super();
	}

	public Dog(String name) {
		super(name);
	}

	public void makeNoise(){
		System.out.println("woof");
	}
}
