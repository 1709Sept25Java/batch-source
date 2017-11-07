package com.revature.exception;

public class LibraryFullException extends Exception {

	private String message = "too many books!";

	/**
	 * 
	 */
	private static final long serialVersionUID = -2862283805529565731L;

	public LibraryFullException() {
		super();
	}

	public LibraryFullException(String message) {
		super(message);
	}

}
