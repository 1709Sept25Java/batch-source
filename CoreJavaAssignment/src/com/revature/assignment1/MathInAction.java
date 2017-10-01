package com.revature.assignment1;

public class MathInAction extends UseMathOperators{//inherits the method form UsMathOperator
	public static void main(String [] args) {
		double a = 10;
		double b = 2;
		UseMathOperators u = new UseMathOperators(a,b);//create a UseMathOperators object with field a and b 
		//call UseMathOperator methods
		u.addition(a, b);
		u.substraction(a, b);
		u.multiplication(a, b);
		u.division(a, b);
	}

}
