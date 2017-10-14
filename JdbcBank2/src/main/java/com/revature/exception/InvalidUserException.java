package com.revature.exception;

public class InvalidUserException extends Exception{

	public InvalidUserException() {
		super("Could not find a user with matching credentials!");
	}
	
}
