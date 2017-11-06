package com.revature.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component(value="tigerService")
@Scope(value="prototype")
public class TigerService extends AnimalService{
	
	private int tigerSpeed = 20;
	private Boolean tigerFull= false;
	@Override
	public int getSpeed() {
		return this.tigerSpeed;
	}
	@Override
	public void setFull(boolean tigerFull) {
		this.tigerFull = tigerFull;
	}
	
	public Boolean getFull() {
		return this.tigerFull;
	}
	
	public void wakeUpAnimal() {
		System.out.println("Tiger is awake");
	}
	
	public void animalChasesYou() {
		System.out.println("AAAAH!");
		System.out.println("Tiger chases you");
	}

}
