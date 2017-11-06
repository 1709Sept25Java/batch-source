package com.revature.service;

import java.util.Scanner;

public class CalculationService extends CalculatorService {

	Scanner scan= new Scanner(System.in);
	
	@Override
	public int getNumber1() {
		System.out.println("Type in your first number");
		int scan1= scan.nextInt();
		return scan1;
	}

	@Override
	public int getNumber2() {
		System.out.println("Type in your first number");
		int scan1= scan.nextInt();
		return scan1;
	}

	@Override
	public String getOp() {
		System.out.println("Type in your first number");
		String scan1= scan.next();
		return scan1;
	}

	@Override
	public void add() {
		System.out.println(getNumber1()+getNumber2());
	}

	@Override
	public void subtract() {
		System.out.println(getNumber1()-getNumber2());
	}

	@Override
	public void multiply() {
		System.out.println(getNumber1()*getNumber2());
	}

	@Override
	public void divide() {
		System.out.println(getNumber1()/getNumber2());
	}

	@Override
	public int choose(String choice, String num1) {
		int datatype=0;
		System.out.println("Choose a datatype: int, double, float");
		scan.nextLine();
		switch (choice) {
		case "int": {
			break;
			}
		case "double": {
			datatype=(int) Double.parseDouble(num1);
			break;
		}
		case "float": {
			datatype=(int) Float.parseFloat(num1);
			break;
		}
		default:
			break;
		}
		return (int) datatype;
	}

}
