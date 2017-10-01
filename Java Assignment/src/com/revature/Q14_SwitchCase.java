package com.revature;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Q14_SwitchCase{
	//method to calculate the square root of a number that the user enters in and then executes 
	//todays date and a string labeled "i am learning core java".
	public static void doCase(int i)
	{
		try( Scanner scan = new Scanner(System.in) )
		{
			switch(i)
			{
				case 1:                 
					System.out.println("Enter a number: ");
					double num = scan.nextDouble();
					System.out.println("The square root of " + num + " is: " + Math.sqrt(num));
					break;
				case 2:
					Date today = Calendar.getInstance().getTime();
					System.out.println("Today's date is: " + today);
					break;
				case 3:
					String str = "I am Learning core java";
					String[] arr = str.split(" ");
					for(String s: arr)
						System.out.println(s);
					break;
			}
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		} }

	public static void main(String[] args)
	{	
		doCase(1);
		System.out.println();
		doCase(2);
		System.out.println();
		doCase(3);	
}
		}