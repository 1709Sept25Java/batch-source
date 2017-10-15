package com.revature.exception;

public class UserNotCreatedException extends Exception{

	public UserNotCreatedException() {
		super("Oh no! That username is already taken! Please try again.");
	}
	
}
