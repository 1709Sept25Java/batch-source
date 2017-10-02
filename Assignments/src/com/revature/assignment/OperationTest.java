package com.revature.assignment;
import java.util.Scanner;


public class OperationTest implements Operations{



@Override
public int addition(int n1, int n2) {
	return n1 + n2;
}

@Override
public int substraction(int num1, int num2) {
		return  num1 - num2; 
}

@Override
public int multiplication(int number1, int number2) {
	
	return number1 * number2 ;
}

@Override
public int division(int nb1, int nb2) {
	
	return nb1 / nb2 ;
}



public static void main(String[]args) {
	OperationTest test = new OperationTest();
	
	System.out.println( "Addition of 7 and 2 is :" + test.addition(7,2));
	System.out.println( "Substraction of 17 and 7 is: " + test.substraction(17, 10));
	System.out.println( "Multiplication of 7 and 3 is :" + test.multiplication(7,3));
	System.out.println( "division of 50 and 5 is " + test.division(50,5));
}




		

}

