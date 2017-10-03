package calculator.exception.examples;

import java.lang.Exception;

public class CalculatorCustomException extends Exception {

	public CalculatorCustomException() 
	{
	}
	public CalculatorCustomException(String msg) 
	{
		super(msg);
	}
	public CalculatorCustomException(Throwable cause) 
	{
		super(cause);
	}
	public CalculatorCustomException(String message, Throwable cause)
    {
        super(message, cause);
    }
}
