package corejava;

import java.util.Scanner;

public class SimpleInterest {

	public static double calculateInterest(double p, double r, double t) {
		return p * r * t;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter in principal."); //read in principal input
		double p = sc.nextDouble();
		
		System.out.println("Enter in rate. (0.00 - 1.00)"); //read in rate input
		double r = sc.nextDouble();
		
		System.out.println("Enter in number of years."); //read in number of years input
		double t = sc.nextDouble();
		
		System.out.println("The interest on a principal of " + p + " with an interest rate of " + r + " in "
				+ t + " years is " + calculateInterest(p , r , t));
	}

}
