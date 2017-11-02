package com.revature.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component(value="bearService")
@Scope(value="prototype")
public class BearService extends AnimalService {
	
	private static int bearSpeed = 14;
	private Boolean bearFull = true; //bears eat before they hibernate
	private static Boolean isWinter = false;

	@Override
	public int getSpeed() {
		return BearService.bearSpeed;
	}

	@Override
	public void setFull(Boolean full) {
		this.bearFull = full;
	}

	@Override
	public Boolean getFull() {
		return this.bearFull;
	}
	
	public void setIsWinter(Boolean isWinter){
		BearService.isWinter = isWinter;
	}
	
	public Boolean getIsWinter(){
		return BearService.isWinter;
	}

	@Override
	public void wakeUpAnimal() {
		System.out.println("Woke up the bear.");
		
	}

	@Override
	public void animalChasesYou() {
		System.out.println("AAAAAAHHHHH!");
		System.out.println("Bear is chasing you.");
		
	}

	public void bearHibernates() throws Exception {
		if (!BearService.isWinter){
			throw new Exception("Bears hibernate in the winter.");
		}
		System.out.println("ZZZZZZZZZZZZZZZZZZ");
		
	}
}
