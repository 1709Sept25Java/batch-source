package com.revature.corejava;

public class Q15_Calculator implements Q15_CalculateInterface {

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
		product = multiplier*multiplicand;
		return product; //multiplies numbers, returns product 
	}
	
	public int division(int dividend, int divisor){
		int quotient;
		quotient = dividend/divisor;
		return quotient; //divides numbers, returns quotient 
	}

	public static void main(String[] args) {
		Q15_Calculator calc = new Q15_Calculator();
		System.out.println(calc.addition(10,2));
		System.out.println(calc.subtraction(10,2));
		System.out.println(calc.multiplication(10,2));
		System.out.println(calc.division(10,2));
		//test cases
	}

}
