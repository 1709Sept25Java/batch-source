package calculator.exception.examples;

import java.util.Scanner;
import java.lang.Exception;

/**Write a program that defines an interface having the following methods: 
 * addition, subtraction, multiplication, and division.  
 * Create a class that implements this interface and provides appropriate functionality to carry 
 * out the required operations.
 *  Hard code two operands in a test class having a 
 *  main method that calls the implementing class.
 *
 *
 *exception divide by zero
 *unchecked exception: nullpointerexception
 */
public class CalculatorWithExceptions implements CalculatorWithExceptionsInterface {

	private double firstNum;
	private double secondNum;
	private String op;
	private double perform;
	
	public static void main(String[] args) 
	{
	   CalculatorWithExceptions math= new CalculatorWithExceptions();
	   math.operators();
	}
	
	public double getFirstNum() {
		return firstNum;
	}
	public double getSecondNum() {
		return secondNum;
	}
	public String getOp() {
		return op;
	}
	public double getPerform() {
		return perform;
	}
	
	public void operators() 
	{	
		System.out.println("This program calculates the addition, subtraction,"
				+ "\n multiplcation, and division between two numbers.");
		Scanner scan= new Scanner(System.in);		
		System.out.println("Type in the first number");
		double firstNum= scan.nextDouble();
		this.firstNum=firstNum;
		
		System.out.println("Type in the operand");
		String op= scan.next();
		this.op=op;
		
		System.out.println("Type in the second number");
		double secondNum= scan.nextDouble();
		this.secondNum=secondNum;
		
		
		switch(op)
		{
		case "+":
			Add();
			System.out.println(perform);
			break;
		case "-":
			Subtract();
			System.out.println(perform);
			break;
		case "*":
			Multiply();
			System.out.println(perform);
			break;
		case "/":
			Divide();
			System.out.println(perform);
			break;
		}
	}
	public void DividedZero() throws CalculatorCustomException
	{
		if(this.secondNum==0)
		{
			try
			{
				//created an error for the nullpointedexception example (unchecked exception)
			this.perform=(Double) null;
			}
			catch(NullPointerException e)
			{
				System.out.println("Null Pointer Exception");
			}
			throw new CalculatorCustomException("Zero divided");
		}
	}
	@Override
	public void Add()
	{
		this.perform=this.firstNum+this.secondNum;
	}

	@Override
	public void Subtract() {
		this.perform=this.firstNum-this.secondNum;
	}

	@Override
	public void Multiply() {
		this.perform=this.firstNum*this.secondNum;
	}

	@Override
	public void Divide() {
		//custom exception
		try
		{
			DividedZero();
			this.perform=this.firstNum/this.secondNum;	
		}
		catch(CalculatorCustomException e)
		{
			System.out.println("Divided by Zero custom exception");
		}
	}
}
