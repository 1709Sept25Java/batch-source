package com.java.corejava;

public class ImplementInterface implements Interface{


	@Override
	public int addition(int num1, int num2) {
	
		return num1+num2;
	}

	@Override
	public int subtraction(int num1, int num2) {
	
		return num1-num2;
	}

	@Override
	public int multiplication(int num1, int num2) {
	
		return num1*num2;
	}

	@Override
	public int dividsion(int num1, int num2) {

		return num1/num2; 
		
	}
	

	public static void main(String[] args) {
	
		ImplementInterface calculator = new ImplementInterface();
		System.out.println(calculator.addition(0, 6));
		System.out.println(calculator.subtraction(0, 6));
		System.out.println(calculator.multiplication(0, 6));
		System.out.println(calculator.dividsion(6, 0));
		
	}


}



//Write a program that defines an interface having the following methods: addition, subtraction, multiplication, and division.  
//Create a class that implements this interface and provides appropriate functionality to carry out the required operations. 
//Hard code two operands in a test class having a main method that calls the implementing class.