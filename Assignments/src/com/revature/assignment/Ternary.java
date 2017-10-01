package com.revature.assignment;
import java.util.Scanner;

public class Ternary {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
	System.out.println(" Enter the first number");
	int number1 = input.nextInt();
	
	System.out.println(" Enter the second  number");
	
	int number2 = input.nextInt();
	int min, max;
	min = number1 < number2 ? number1 : number2 ;
	max = number1 < number2 ? number2 : number1 ;
	System.out.println(" The minimun of the numbers is : " + number1 +" and" + number2 + " is : " + min );
	System.out.println(" The maximum of the numbers is : " + number1 +" and" + number2 + " is : " + max );
	
	
	}

}
