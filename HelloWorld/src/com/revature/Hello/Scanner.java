package com.revature.Hello;

public class Scanner {

	public class ScannerCalculator {
		public Number add(number1, number2)
		{
			double sum ;
			sum = number1 + sumber2 ;
		}
		
	public static void main(String [] args) {
		
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
			System.out.println(" Invalid");
	} ;

	System.out.println(" Please enter two numbers");
	double num1 ;
	double num2 ;
	input.nextDouble();

	num1=input.nextDouble();
	num2 = input.nextDouble();
	double number ;
	}

}
