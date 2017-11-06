package com.revature.service;

public abstract class CalculatorService {
	
	//getting calculator info from user
	public abstract int getNumber1();
	public abstract int getNumber2();
	public abstract String getOp();
	public abstract int choose(String choice, String num1);
	//calculations
	public abstract void add();
	public abstract void subtract();
	public abstract void multiply();
	public abstract void divide();
	
	//info
	public void info() {
		System.out.println("Your result is: ");
	}
	

}
