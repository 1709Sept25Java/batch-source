package com.revature.java;
import java.util.Scanner;

public class Exceptions {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int x = 1;
		System.out.println(" Please enter first number");
		do {
		try {
		int n1 = input.nextInt();
		System.out.println(" Enter second number");
		int n2 = input.nextInt();
		int answer = n1/n2;
		System.out.println(answer);
		 x= 2;
	 
		}
		catch( Exception e) {
			System.out.println(" it wont work, please enter a valid number  ");
		}
		}while(x==1);
		
	

	}

}
