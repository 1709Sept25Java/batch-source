package com.revature.exception;

public class PasswordMismatchException extends Exception{

	public PasswordMismatchException(){
		super("The passwords don't match!");
	}
	
}
