package com.JDBCBank.exceptions;

public class InvalidPasswordException extends Exception{
	private static final long serialVersionUID = 4722214015108067808L;

	public InvalidPasswordException(String message) {
		super(message);
	}

}
