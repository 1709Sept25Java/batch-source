package com.revature.assignment;
import java.util.Scanner;


public class OperationTest implements Operations{



@Override
public int addition(int n1, int n2) {
	int sum = n1 + n2 ;// TODO Auto-generated method stub
	return sum ;
}

@Override
public int substraction(int num1, int num2) {
	int difference = num1 - num2 ;// TODO Auto-generated method stub
	return difference;
}

@Override
public float multiplication(float number1, float number2) {
	float product = number1 * number2 ;// TODO Auto-generated method stub
	return product ;
}

@Override
public double division(double nb1, double nb2) {
	double answer = nb1 / nb2 ;// TODO Auto-generated method stub
	return answer ;
}
public OperationTest( 7, 3. 10, 5. 7.0, 3.0, 50.0,5.0){
	
	System.out.println( " Addition" + test.addition());
	System.out.println( "Substraction" + test.substraction());
	System.out.println( "Multiplication" + test.addmultiplicatin());
	System.out.println( "division" + test.division())
}


public static void main(String [] args){
	
OperationTest test = new OperationTest();


		

}
}
