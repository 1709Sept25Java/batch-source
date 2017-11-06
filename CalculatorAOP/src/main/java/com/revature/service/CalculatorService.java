package com.revature.service;

import java.util.Scanner;

import org.springframework.stereotype.Component;

@Component(value="calculatorService")
public class CalculatorService {
	
	public Number calculate() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter the data type you would like to add:");
		String dataType = scan.nextLine().toLowerCase();
		if(dataType.equals("integer") || dataType.equals("double") || dataType.equals("short") || dataType.equals("float") || dataType.equals("long")) {
			System.out.println("Please enter your augend:");
			String s1 = scan.nextLine();
			System.out.println("Please enter your addend:");
			String s2 = scan.nextLine();
			scan.close();
			switch (dataType) {
				case "integer":
					return addInteger(s1,s2);
				case "double":
					return addDouble(s1,s2);
				case "short":
					return addShort(s1,s2);
				case "float":
					return addFloat(s1,s2);
				case "long":
					return addLong(s1,s2);
				default:
					return 0;
			}
		}
		else {
			System.out.println("I'm sorry, that is not a valid subtype of Number.");
			scan.close();
			return 0;
		}
		
	}
	
	public static Number addInteger(String s1, String s2) {
		int n1 = Integer.parseInt(s1);
		int n2 = Integer.parseInt(s2);
		int sum = n1+n2;
		System.out.println("The sum of your numbers is: "+sum);
		return sum;
	}
	
	public static Number addDouble(String s1, String s2) {
		double n1 = Double.parseDouble(s1);
		double n2 = Double.parseDouble(s2);
		double sum = n1+n2;
		System.out.println("The sum of your numbers is: "+sum);
		return sum;
	}
	
	public static Number addShort(String s1, String s2) {
		short n1 = Short.parseShort(s1);
		short n2 = Short.parseShort(s2);
		int sum = n1+n2;
		System.out.println("The sum of your numbers is: "+sum);
		return sum;
	}
	
	public static Number addFloat(String s1, String s2) {
		float n1 = Float.parseFloat(s1);
		float n2 = Float.parseFloat(s2);
		float sum = n1+n2;
		System.out.println("The sum of your numbers is: "+sum);
		return sum;
	}
	
	public static Number addLong(String s1, String s2) {
		long n1 = Long.parseLong(s1);
		long n2 = Long.parseLong(s2);
		long sum = n1+n2;
		System.out.println("The sum of your numbers is: "+sum);
		return sum;
	}

}
