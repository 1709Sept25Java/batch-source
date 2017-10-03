package com.revature.exceptions;

public class ZeroException extends Exception {

	public ZeroException() {
		super("Can't divide by zero"); 
	}
}
