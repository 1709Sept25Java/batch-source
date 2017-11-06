package com.revature.service;

import org.springframework.stereotype.Component;

@Component(value="personService")
public class PersonService {
	
	private static int maxHumanSpeed = 15;
	
	public static int getSpeed() {
		return PersonService.maxHumanSpeed;
	}

}