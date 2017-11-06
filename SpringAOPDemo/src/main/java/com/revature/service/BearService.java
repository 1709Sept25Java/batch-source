package com.revature.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component(value="bearService")
@Scope(value="prototype")
public class BearService extends AnimalService{

	private static int bearSpeed = 14;
	private Boolean bearFull = false;
	private static Boolean isWinter = false;
	
	@Override
	public int getSpeed() {
		return BearService.bearSpeed;
	}

	@Override
	public void setFull(boolean bearFull) {
		this.bearFull = bearFull;
		
	}

	@Override
	public Boolean getFull() {
		return this.bearFull;
	}
	
	public void setIsWinter(Boolean isWinter) {
		BearService.isWinter = isWinter;
	}
	
	public Boolean getIsWinter() {
		return BearService.isWinter;
	}

	@Override
	public void wakeUpAnimal() {
		System.out.println("Woke up the bear.");
		
	}

	@Override
	public void animalChasesYou() {
		System.out.println("AAAAH!");
		System.out.println("Tiger chases you");
	}
	
	public void bearHibernates() throws Exception {
		
		if(!BearService.isWinter) {
			throw new Exception("Bears hibernate in the winter");
		}
		System.out.println("ZZZZZZzzzzzzzz");
	}

}
