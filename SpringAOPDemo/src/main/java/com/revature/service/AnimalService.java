package com.revature.service;

public abstract class AnimalService {

	public abstract int getSpeed();
	
	public abstract void setFull(boolean isFull);
	
	public abstract Boolean getFull();
	
	public abstract void wakeUpAnimal();
	
	public abstract void animalChasesYou();
	
	public void animalCatchesYou() {
		System.out.println("Hope it's not hungry");
	}
	
}
