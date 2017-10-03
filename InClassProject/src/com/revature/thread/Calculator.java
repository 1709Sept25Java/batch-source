package com.revature.thread;

public class Calculator {

	public int addition(int augend, int addend) {
		 	int sum;
		 		sum = augend+addend;
		 	return sum; //adds numbers, returns sum
		 	}
		 	
		 	public int subtraction(int minuend, int subtrahend){
		 		int difference;
		 		difference = minuend - subtrahend;
		 		return difference; //subtracts numbers, returns difference
		 	}
		 	
		 	public int multiplication(int multiplier, int multiplicand){
		 		int product;
		 		//multiplier = (Integer) null;
		 		//unchecked exception
		 		product = multiplier*multiplicand;
		 		return product; //multiplies numbers, returns product 
		 	}
		 	
		 	public int division(int dividend, int divisor) throws DivideByZeroException {
		 			if (divisor == 0) {
		 				throw new DivideByZeroException("Cannot divide by zero");
		 		}
		 		
		 		return dividend/divisor; //divides numbers, returns quotient 
		 	}
		 
		 	public static void main(String[] args) throws DivideByZeroException{
		 		Calculator calc = new Calculator();
		 		System.out.println(calc.addition(10,2));
		 		System.out.println(calc.subtraction(10,2));
		 		System.out.println(calc.multiplication(10,2));
		 		System.out.println(calc.division(10,0));
		 		//test cases
		 	}
		 
		 }

