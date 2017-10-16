package com.revature.bank;

//Register: User with that username already exists so registration fails!
public class DuplicateUsernameException extends Exception {

	private static final long serialVersionUID = 1L;

	public DuplicateUsernameException(String message) {
		super(message);
	}

}
