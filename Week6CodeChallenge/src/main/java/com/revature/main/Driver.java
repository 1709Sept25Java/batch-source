package com.revature.main;

import java.util.Scanner;

import org.springframework.context.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.service.CalculatorServiceImpl;

public class Driver {
	
	public static void main(String[] args) {
		
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
		System.out.println("What numeric type would you like to calculate with? (int or double)");
		String type = sc.next();
		
		System.out.println("What operation would you like to do? (add, subtract, multiply, divide)");
		String op = sc.next();
		
		CalculatorServiceImpl cs = (CalculatorServiceImpl) ac.getBean("calculatorServiceImpl");
		
		if(type.equals("int")) {
			System.out.println("Enter your first number.");
			int n1 = sc.nextInt();
			System.out.println("Enter your second number.");
			int n2 = sc.nextInt();
			
			switch(op) {
				case "add":
					try {
						cs.add(n1, n2);
					}catch (Exception e) {
						e.printStackTrace();
					}
					break;
					
				case "subtract":
					try {
						cs.sub(n1, n2);
					}catch (Exception e) {
						e.printStackTrace();
					}
					break;
					
				case "multiply":
					try {
						cs.mult(n1, n2);
					}catch (Exception e) {
						e.printStackTrace();
					}
					break;
					
				case "divide":
					try {
						cs.div(n1, n2);
					}catch (Exception e) {
						e.printStackTrace();
					}
					break;
					
				default:
					System.out.println("Can not perform operation");
					break;
			}
		}else {
			System.out.println("Enter your first number.");
			double n1 = sc.nextDouble();
			System.out.println("Enter your second number.");
			double n2 = sc.nextDouble();
			
			switch(op) {
				case "add":
					try {
						cs.add(n1, n2);
					}catch (Exception e) {
						e.printStackTrace();
					}
					break;
					
				case "subtract":
					try {
						cs.sub(n1, n2);
					}catch (Exception e) {
						e.printStackTrace();
					}
					break;
					
				case "multiply":
					try {
						cs.mult(n1, n2);
					}catch (Exception e) {
						e.printStackTrace();
					}
					break;
					
				case "divide":
					try {
						cs.div(n1, n2);
					}catch (Exception e) {
						e.printStackTrace();
					}
					break;
					
				default:
					System.out.println("Can not perform operation");
					break;
			}
			
		}
		System.out.println("");
		}
	}
}
