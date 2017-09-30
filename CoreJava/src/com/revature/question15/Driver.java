package com.revature.question15;

public class Driver {

	public static void main(String[] args) {
		int a=15, b=5;
		
		MyMaths maths = new MyMaths();
		int sum = maths.addition(a, b);
		int remainder = maths.subtration(a, b);
		int product = maths.multiplication(a, b);
		int multiple = maths.division(a, b);
		
		System.out.println(a+" plus "+b+" is: "+sum);
		System.out.println(a+" minus "+b+" is: "+remainder);
		System.out.println(a+" times "+b+" is: "+product);
		System.out.println(a+" divided by "+b+" is: "+multiple);
	}
	
}
