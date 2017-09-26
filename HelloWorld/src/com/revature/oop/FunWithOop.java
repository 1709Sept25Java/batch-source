package com.revature.oop;

public class FunWithOop {

	public static void main(String[] args) {
		Cat c1 = new Cat("Sue");
		System.out.println(c1.toString());
		
		//instance method so we get the overriden version
		c1.makeNoise();
	
		Cat c2 = new Cat("Mike");
		System.out.println(c2.toString());
		
		Dog d1 = new Dog("Kathi");
		System.out.println(d1.toString());
		Dog d2 = new Dog("Don");
		System.out.println(d2.toString());		
		
		System.out.println(c2.maxLives); //field should be accessed in a static way
		
		c2.maxLives = 10;
		System.out.println(c1.maxLives); //oh no it changed all the cats maxLives
		
		//Better way to access static class member 
		Cat.maxLives = 9;
		
		//Put all of our animals into an array using polymorphism
		/* 
		 * Arrays:
		 * Elements must be of the same type, length must be specified
		 * length is immutable (block of contiguous memory allocated at instantiation 
		 * At initialization all ell elements to default values for useful methods
		 * java.util.Arrays (note the s) for useful methods
		 */
		Animal[] animalArray = new Animal[4];
		animalArray[0] = c1;
		animalArray[1] = c2;
		animalArray[2] = d1;
		animalArray[3] = d2;
		
		for (int i=0; i<animalArray.length; i++) {
			animalArray[i].makeNoise();
		}
		
		//Cast between super- and sub- classes
		
		((Animal) c1).makeNoise(); //this will still give the Cat version of makeNoise()
		Animal a2 = (Animal) c2; //treating c2 as its parent class ("upcasting")
		//This throws a ClassCastException because the actual type of a2 is Cat
		Dog d3 = (Dog) a2; //"downcasting" from Animal to subclass, Dog 
		
	}
}
