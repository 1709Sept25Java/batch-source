package com.revature.assignment1;

public class UseMathOperators implements MathOperators{//emplement methods for Mathoperators

	//private variable of Use MathOperators class
	private double a;
	private double b; 
	
	//constructor for UseMathoperators class
	public UseMathOperators() {
		super();
	}
	
	//constructor with private variable as arguments 
	public UseMathOperators(double a, double b) {
		this.a = a;
		this.b = b;
	}
	
	public void addition(double a, double b) {
		System.out.println("The sum of: " +this.a + " and " + this.b + " is " + (this.a + this.b) + " . ");
	}

	@Override
	public void substraction(double a, double b) {
		System.out.println("The difference between: " + this.a + " and " + this.b + " is " + (this.a - this.b) + " . ");
		
	}

	@Override
	public void multiplication(double a, double b) {
		System.out.println("The product is: " + this.a + " and " + this.b + " is " + (this.a * this.b) + " . ");
		
	}

	@Override
	public void division(double a, double b) {
		System.out.println(" The quotien of: " + this.a + " and " + this.b + " is " + (this.a / this.b) + " . ");
		
	}
}
