package com.revature.assignment1;

import java.util.Scanner;

public class MinUsingTernary {

	public static void main(String[] args) {
		minNumTernary();
	}

	public static void minNumTernary() {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the first number: ");
		Double number1 = in.nextDouble();
		System.out.println("Enter the second number: ");
		Double number2 = in.nextDouble();
		
		//when I pass same number twice, this program doesn't catch it
		//it still passes that number as minimum
		
		Double min = (number1 < number2) ? number1 : number2;
		System.out.println(min + " is the minimum number");

		in.close();
	}

}
