package questions;

import java.math.*;
import java.util.*;
/*
 *Write a program that demonstrates the switch case. 
 *Implement the following functionalities in the cases:java 
Case 1: Find the square root of a number using the Math class method.
Case 2: Display today’s date.
Case 3: Split the following string and store it in a string array.
           	“I am learning Core Java”
 */
public class Question_14 {

	public static void main(String[] args) 
	{
		switching();
	}
	
	public static void switching() {
		Scanner scan=new Scanner(System.in);
		System.out.println("Type in a number based on the list: "
				+"\nCase 1: Find the square root of a number using the Math class method.\r\n" + 
				"Case 2: Display today’s date.\r\n" + 
				"Case 3: Split the following string and store it in a string array.\r\n" + 
				"           	“I am learning Core Java”");
		int choice=scan.nextInt();
		
		
		switch(choice)
		{
		case 1:
		{
			System.out.println("Type in a number");
			int sqrt=scan.nextInt();
			System.out.println(Math.sqrt(sqrt));
			break;
		}
		case 2:
		{
			Date today=new Date();
			System.out.println(today);
			break;
		}
		case 3:
		{
			String learn="I am learning Core Java";
			String []arr=new String[learn.length()];
			learn.split(" ");
			arr[0]=learn;
			System.out.println(learn);
			break;
		}
		
	}

}
}
