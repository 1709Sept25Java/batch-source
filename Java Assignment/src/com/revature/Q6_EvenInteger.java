package com.revature;
import java.util.Scanner;
public class Q6_EvenInteger {
		//method to see if a number is even or odd
		public static void main(String []args )    {
		 
	    int number;
	    Scanner in= new Scanner(System.in);
	 
	    System.out.println("Enter a number to check even or odd");
	    number=in.nextInt();
	 
	    if((number % 2)==0){
	        System.out.println(+number+" is Even number");
	    }else{
	        System.out.println(+number+" is Odd Number");
	    }
	 
	}
	} 