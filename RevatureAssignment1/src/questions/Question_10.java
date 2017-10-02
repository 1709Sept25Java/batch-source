package questions;
import java.util.Scanner;

/**
Find the minimum of two numbers using ternary operators.
 */
public class Question_10 {

	public static void main(String[] args) {
		minOfTwo();
	}
	
	public static void minOfTwo()
	{
		Scanner scan= new Scanner(System.in);
		System.out.println("Please type in two different numbers, "
				+ "\nand the program will calculate which is the "
				+ "\nminimum of the two!");
		int a=scan.nextInt();
		int b=scan.nextInt();
		
		if(a<b)
		{
			System.out.println(a+ " is smaller than "+ b);
		}
		else if(b<a)
		{
			System.out.println(b+ " is smaller than "+ a);
		}
		else if(a==b) {
			System.out.println(a+ " " + b +" are equal!");
		}
		else {
			System.out.println("Error!");
		}
		
	}

}
