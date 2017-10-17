package com.revature.oop;

public class FunWithOop {

	public static void main(String[] args) {
		
		Cat c1 = new Cat("Sue");
		System.out.println(c1.equals(c1.toString()));
		
		// instance methos, so we get the overridden version 
		c1.makeNoise();
		
		//static variable maxLives 
		Cat c2 = new Cat("Mike");
		System.out.println(c2.toString());
		
		System.out.println(c2.maxLives); 
		//field should be accessed in static way 
		c2.maxLives = 10; 
		System.out.println(c1.maxLives);
		
		Dog d1 = new Dog("Kathi");
		System.out.println(d1.toString());
		
		Dog d2 = new Dog("Max");
		System.out.println(d1.toString());
		
		// better way o access static class member
		//setting act to normal 
		Cat.maxLives = 9; 
		
		// put all of our animals into array using polymorphism 
		/*
		 * Arrays: 
		 * Element must of the same type, length must be specified
		 * length is immutable (block of continuous memory allocated at instantiation 
		 * all elements are set to default value for that datatype 
		 * java.util.Arrays for usefull methods
		 */
		Animal [] animalArray = new Animal[4];
		animalArray[0] = c1; //indexes 
		animalArray[1] = c2;
		animalArray[2] = d1;
		animalArray[3] = d2;
		
		for (int i = 0; i<animalArray.length; i++) {
			animalArray[i].makeNoise();
			
		}
		
		//Cast between super- & sub- classes.
		((Animal) c1).makeNoise(); //this will still give the Cat version of makeNoise()
		Animal a2 = (Animal) c2; //treating c2 as its parent class (up-casting) 
		/*
		 * this throws a ClassCastException because the actual type of a2 is Cat
		 */
		// Dog d3 = (Dog) a2; //"down-casting" from animal to a subclass dog *problem in this case not all animals are dog 
		
		

	}

}
