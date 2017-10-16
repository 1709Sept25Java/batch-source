package com.revature.bank;

//Login: User was not found because username and/or password was incorrect 
public class UserNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	public UserNotFoundException(String message) {
		super(message);
	}

}
