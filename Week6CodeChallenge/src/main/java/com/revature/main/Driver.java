package com.revature.main;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Driver {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Please select the type of numbers you want to add from the list below: ");
		System.out.println("1) Byte");
		System.out.println("2) Short");
		System.out.println("3) Integer");
		System.out.println("4) Long");
		System.out.println("5) Float");
		System.out.println("6) Double");
		int choice = Integer.parseInt(sc.nextLine());
		
		System.out.println("Please enter oporator you wish to user ( + , - , * , / ):");
		String oporator = sc.nextLine();
		
		switch (choice) {
		case 1:
			ac.getBean("byteCalculator");
			System.out.println("Enter first number: ");
			Byte a1 = Byte.parseByte(sc.nextLine());
			System.out.println("Enter second number: ");
			Byte b1 = Byte.parseByte(sc.nextLine());
			break;
		case 2:
			ac.getBean("shortCalculator");
			System.out.println("Enter first number: ");
			Short a2 = Short.parseShort(sc.nextLine());
			System.out.println("Enter second number: ");
			Short b2 = Short.parseShort(sc.nextLine());
			break;
		case 3:
			ac.getBean("integerCalculator");
			System.out.println("Enter first number: ");
			Integer a3 = Integer.parseInt(sc.nextLine());
			System.out.println("Enter second number: ");
			Integer b3 = Integer.parseInt(sc.nextLine());
			break;
		case 4:
			ac.getBean("longCalculator");
			System.out.println("Enter first number: ");
			Long a4 = Long.parseLong(sc.nextLine());
			System.out.println("Enter second number: ");
			Long b4 = Long.parseLong(sc.nextLine());
			break;
		case 5:
			ac.getBean("floatCalculator");
			System.out.println("Enter first number: ");
			Float a5 = Float.parseFloat(sc.nextLine());
			System.out.println("Enter second number: ");
			Float b5 = Float.parseFloat(sc.nextLine());
			break;
		case 6:
			ac.getBean("doubleCalculator");
			System.out.println("Enter first number: ");
			Double a6 = Double.parseDouble(sc.nextLine());
			System.out.println("Enter second number: ");
			Double b6 = Double.parseDouble(sc.nextLine());
			break;
		default:
			System.out.println("Not a valid option");
			break;
		}
		
		
		sc.close();
		
		((AbstractApplicationContext) ac).close();
	}
	
}
