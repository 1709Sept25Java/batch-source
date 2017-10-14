package com.revature.exception;

public class OverdraftException extends Exception{

	public OverdraftException() {
		super("You can't withdraw more money than you have!");
	}
	
}
