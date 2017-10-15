package bank.exceptions;

public class AccountNotEmptyException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1861273683508882341L;

	public AccountNotEmptyException (String message) {
		super(message);
	}
}
