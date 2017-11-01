package com.revature.service;

public abstract class AnimalService {

	//how fast is the animal
	public abstract int getSpeed();
	//is the animal hungry
	public abstract void setFull(boolean full);
	//
	public abstract Boolean getFull();
	
	//your actions and their consequences
	public abstract void wakeUpAnimal();
	public abstract void animalChasesYou();
	
	public void animalCatchesYou() {
		System.out.println("Hope its not hungry");
	}
}
