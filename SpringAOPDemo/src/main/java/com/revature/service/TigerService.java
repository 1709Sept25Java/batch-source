package com.revature.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component(value="tigerService")
@Scope(value="prototype")
public class TigerService extends AnimalService{

	private static int tigerSpeed = 20;
	private Boolean tigerFull=false;
	
	@Override
	public int getSpeed() {
		return TigerService.tigerSpeed;
	}

	@Override
	public void setFull(boolean full) {
		this.tigerFull=full;
	}

	@Override
	public Boolean getFull() {
		// TODO Auto-generated method stub
		return this.tigerFull;
	}

	@Override
	public void wakeUpAnimal() {
		
		System.out.println("woke up tiger");
	}

	@Override
	public void animalChasesYou() {

		System.out.println("AHHHHHHHH");
		System.out.println("Tiger is chasing you. ");
	}

}
