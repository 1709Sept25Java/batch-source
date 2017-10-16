package com.JDBCBank.exceptions;

public class UserDoesNotExistException extends Exception {
	private static final long serialVersionUID = 6016215018947446194L;

	public UserDoesNotExistException(String message) {
		super(message);
	}
 

}
