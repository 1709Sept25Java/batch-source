package week1;

import java.util.Scanner;

public class ScannerCalculator 
{
	public static void main (String[] args)
	{
		ScannerCalculator.calculate();
	}

	public static void calculate()
	{
		int a=0, b=0;
		float c=0;
		int datatype;
		String dt="";
		
		Scanner scan= new Scanner(System.in);
		System.out.println("This program with calculate two different numbers being added, "
				+ "\n after selecting the datatype: ");
		
		System.out.println("Type in the datatype from the following: "
				+"\n 1. int"
				+"\n 2. double"
				+"\n 3. float");
		
		datatype=scan.nextInt();
		
		
		switch(datatype)
		{
		case 1: 
			dt="%.0f";
		break;
		
		case 2: 
			dt="%.16f";
		break;
		
		case 3:
			dt="%.7f";
		break;
		
		default: 
		 	dt="Error";
		}
		
		//adding the numbers, had problems properly converting the numbers
		System.out.println("Type in the first number to add");
		//scanner looks for Int, will not work if typed in another data type Ex: 2.25
		//planning to convert into a String first, and then formating that instead
		a= scan.nextInt();
		
		System.out.println("Type in the second number to add");
		b= scan.nextInt();
		scan.close();
	
		System.out.println("Adding the two numbers");

		c=a+b;
		
		System.out.printf(dt,c);
	}
}