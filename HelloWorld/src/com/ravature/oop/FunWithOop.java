package com.ravature.oop;

public class FunWithOop {
	public static void main(String[] args) {
		Cat c1 = new Cat("Sue");
		System.out.println(c1.toString());
		
		//instance method, so we get the overriden version
		c1.makeNoise();
		
		//static variable maxlives
		Cat c2 = new cat("Mike");
		System.out.println();
	}

}
