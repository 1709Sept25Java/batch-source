package questions;

import java.util.Scanner;

/**Write a program that defines an interface having the following methods: 
 * addition, subtraction, multiplication, and division.  
 * Create a class that implements this interface and provides appropriate functionality to carry 
 * out the required operations.
 *  Hard code two operands in a test class having a 
 *  main method that calls the implementing class.
 *
 */
public class Question_15 implements Question_15_Interface {

	private double firstNum;
	private double secondNum;
	private String op;
	private double perform;
	
	public static void main(String[] args) 
	{
	   Question_15 math= new Question_15();
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
		this.perform=this.firstNum/this.secondNum;
	}
}
