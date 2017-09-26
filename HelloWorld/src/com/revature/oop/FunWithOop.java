package com.revature.oop;

public class FunWithOop {

	public static void main(String[] args) {
		
		Cat c1= new Cat("Sue");
		System.out.println(c1.toString());
		
		//instance method, so we get the overridden version
		c1.makeNoise();
		
		//static variable maxLives
		Cat c2 = new Cat("Mike");
		System.out.println(c2.toString());
		
		Dog d1 = new Dog("Lin");
		Dog d2 = new Dog("Don");
		
		System.out.println(c2.maxLives); //field should be accessed in a static way
		c2.maxLives = 10;
		
		System.out.println(c1.maxLives); //on no changed for all cats
		
		//better way to access static class member
		//setting it back to normal
		Cat.maxLives = 9;
		
	}
}
