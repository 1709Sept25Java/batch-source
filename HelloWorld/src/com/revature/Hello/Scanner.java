package com.revature.Hello;
import java.util.Scanner;


	public class ScannerCalculator {
		
		public  numeric add( double number1, double number2){
		{
		return number1 + number2 ;
		}
	public static void main(String [] args){
		ScannerCalculator scan  = new ScannerCalculator();	
		double numbers;
		
		Scanner input = new Scanner(System.in);
		
		System.out.println(" What data type do you prefer");
		if ( input.hasNextInt())
		{ 
			numbers = (double) input.nextInt();
			}
		else if (input. hasNextFloat() )
		{
			numbers = (double) input.nextFloat();
			}
		
			else if (input.hasNextLong() )
			{
				numbers = (double)input.nextLong() ;
			}
			else if (input.hasNextShort())
			{
				numbers = (double)input.nextShort();
				}
			
			else if (input.hasNextDouble() );
			 {
				 numbers = (double) input.nextDouble();
			 }
			 else
			 {
			System.out.println(" Invalid");
	} 

	System.out.println(" Please enter two numbers");

	 double num1 = input.nextDouble();
	double num2 = input.nextDouble();
	System.out.println(" the sume is" + scan.numeric() );
	
	}

}

