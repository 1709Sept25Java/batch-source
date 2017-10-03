package com.revature.exceptions;

public class Driver {

	public static void main(String[] args) {

		Calculator calculations = new Calculator();
		int x = 12;
		int y = 0;
		try {
			calculations.division(x, y);
		}
		catch (ZeroException e) {
			e.printStackTrace();
		}
		
		Integer z = getValue("ab"); //null object
		
		try {
			calculations.division(z, x);
		}

		catch (ZeroException e) {
			e.printStackTrace();
		}
	}
	
	public static Integer getValue(String str) {
		return null;
	}

}
