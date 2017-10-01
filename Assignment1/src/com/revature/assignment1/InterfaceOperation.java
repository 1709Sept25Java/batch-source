package com.revature.assignment1;

public class InterfaceOperation implements Interface1 {

	@Override
	public double addition(double a, double b) {
		return a+b;
	}

	@Override
	public double subtraction(double a, double b) {
		return a-b;
	}

	@Override
	public double multiplication(double a, double b) {
		return a*b;
	}

	@Override
	public double division (double a, double b) {
		if (b==0) {
			System.out.println("Division is not possible!");
		} 
		return a/b;
		
	}



	
	
}


