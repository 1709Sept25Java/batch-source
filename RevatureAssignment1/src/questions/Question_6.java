package questions;

import java.util.Scanner;
//Write a program to determine if an integer is even without using the modulus operator (%)
public class Question_6 
{
	public static void main(String[] args) 
	{
		Question_6.even();
	}
	public static void even() 
	{
		Scanner scan= new Scanner(System.in);
		
		System.out.println("Type in an integer, and the program will determine if it is even.");
		String num= scan.next();

		scan.close();
		
		if((num.endsWith("0"))
				||num.endsWith("2")
				||num.endsWith("4")
				||num.endsWith("6")
				||num.endsWith("8"))
		{
			System.out.println("The number: "+num + " is even!");
		}
		else
		{
			System.out.println("The number: "+num + " is odd!");
		}
	}
}
