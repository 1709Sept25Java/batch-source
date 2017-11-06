package com.revature.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component(value="calculatorServiceImpl")
@Scope(value="prototype")
public class CalculatorServiceImpl extends CalculatorService {

	@Override
	public int add(int a, int b) {
		int an = a + b;
		System.out.println(a + " + " + b + " = " + an);
		return an;
	}

	@Override
	public int sub(int a, int b) {
		int an = a - b;
		System.out.println(a + " - " + b + " = " + an);
		return an;
	}

	@Override
	public int mult(int a, int b) {
		int an = a * b;
		System.out.println(a + " * " + b + " = " + an);
		return an;
	}

	@Override
	public int div(int a, int b) {
		int an = a / b;
		System.out.println(a + " / " + b + " = " + an);
		return an;
	}

	@Override
	public double add(double a, double b) {
		double an = a + b;
		System.out.println(a + " + " + b + " = " + an);
		return an;
	}

	@Override
	public double sub(double a, double b) {
		double an = a - b;
		System.out.println(a + " - " + b + " = " + an);
		return an;
	}

	@Override
	public double mult(double a, double b) {
		double an = a * b;
		System.out.println(a + " * " + b + " = " + an);
		return an;
	}

	@Override
	public double div(double a, double b) {
		double an = a / b;
		System.out.println(a + " / " + b + " = " + an);
		return an;
	}

}
