package com.revature.service;

public abstract class AnimalService {
	
	//how fast is the animal?
	public abstract int getSpeed();
	
	//is the animal hungry? 
	public abstract void setFull(Boolean full);
	public abstract Boolean getFull();
	
	//your actions and their consequences
	public abstract void wakeUpAnimal();
	public abstract void animalChasesYou();
	
	public void animalCatchesYou(){
		System.out.println("Hope it's not hungry");
	}

}