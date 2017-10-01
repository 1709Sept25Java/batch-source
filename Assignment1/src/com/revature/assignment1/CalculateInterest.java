package com.revature.assignment1;

import java.util.Scanner;

public class CalculateInterest {

	public static void main(String[] args) {

		calcInterest();

	}

	public static void calcInterest() {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter principle amount :");
		float principle = scanner.nextFloat();
		System.out.println("Enter time in years : ");
		float time = scanner.nextFloat();
		System.out.println("Enter rate annually : ");
		float rate = scanner.nextFloat();
		float interest = (principle * time * rate) / 100;
		System.out.println("Simple interest of the amount is : " + interest);
		scanner.close();

	}

}
