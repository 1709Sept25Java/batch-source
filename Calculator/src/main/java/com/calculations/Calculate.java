package com.calculations;

import java.util.Scanner;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component(value="calculate")
@Scope(value="prototype")
public class Calculate extends Calculator{


	Scanner sc= new Scanner(System.in);
	private double num1= sc.nextInt();
	private double num2= sc.nextInt();
	
	
	@Override
	public double add() {
		return this.num1+this.num2;
		
	}

	@Override
	public double subtract() {
		return this.num1-this.num2;
		
	}

	@Override
	public double multiple() {
		return this.num1*this.num2;
		
	}

	@Override
	public double divide() {
		return this.num1/this.num2;
		
	}

	
}
