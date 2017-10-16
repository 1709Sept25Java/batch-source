package com.java.corejava;

import java.util.Scanner;

public class TernaryOperators { //result = testCondition ? value1 : value2
	

	public static void main(String[] args) {
		
		
		Scanner in1 = new Scanner(System.in);
		System.out.println("Enter fist number:");
		int a = in1.nextInt();
		
		Scanner in2 = new Scanner(System.in);
		System.out.println("Enter fist number:");
		int b = in2.nextInt();
		
		int min;
		
		min = (a < b ) ? a : b; //  if the integer a is < b... boolean is true and a is the smallest, otherwise, b is the smallest
		System.out.println("The smallest number entered is: "+min);

	}

}

