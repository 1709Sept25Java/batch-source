package com.revature.hello;
import java.util.Scanner;
public class ScannerCalculator {
	void Addition(int number1, int number2) {
		
		int sum = number1+number2;
		System.out.println(sum);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ScannerCalculator sc = new ScannerCalculator();
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter datatype");
		int data = scan.nextInt();
		
		if(data == 1) {
			System.out.print("Enter numbers");
			
			int number1 = scan.nextInt();
			int number2 = scan.nextInt();
			sc.Addition(number1,number2);
		}
		else {
			System.out.println("try again");
		}
		
		
	}
}
