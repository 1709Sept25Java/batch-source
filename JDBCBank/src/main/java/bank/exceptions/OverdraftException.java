package bank.exceptions;

public class OverdraftException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8594194859644627658L;

	public OverdraftException (String message) {
		super(message);
	}
}
