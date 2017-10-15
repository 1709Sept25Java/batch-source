package bank.exceptions;

public class UsernameDoesNotExistException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6016215018947446194L;

	public UsernameDoesNotExistException(String message) {
		super(message);
	}
}
