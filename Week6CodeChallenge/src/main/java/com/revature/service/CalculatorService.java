package com.revature.service;

public abstract class CalculatorService {

	//user input is int
	public abstract int add(int a, int b);
	public abstract int sub(int a, int b);
	public abstract int mult(int a, int b);
	public abstract int div(int a, int b);
	
	//user input is double 
	public abstract double add(double a, double b);
	public abstract double sub(double a, double b);
	public abstract double mult(double a, double b);
	public abstract double div(double a, double b);
}
