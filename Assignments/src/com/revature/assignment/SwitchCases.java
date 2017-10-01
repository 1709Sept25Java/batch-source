package com.revature.assignment;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Scanner;

public class SwitchCases {
	public static void main(String []args){
		int choice;
		Scanner input = new Scanner(System.in);
		System.out.println("Enter your choice:"
				
				+ "\n1)Find the square root of number\n2)"
				
				+ "Display today's date\n3)Split the string and store in array\n");
		
		choice=input.nextInt();
		switch(choice){
		
		case 1:
			System.out.println("Enter the number\n");
			int m=input.nextInt();
			double squareRoot=Math.sqrt(m);
			System.out.println("Square root of "+ m+" is "+squareRoot);
			break;
			case 2:
			LocalDateTime date = LocalDateTime.now();
			System.out.println(date.toString());
			break;
			
			case 3:
			String str="I am learning Core Java";
			String[] strArray=str.split(" ");
			for(int i=0;i<strArray.length;i++){
			System.out.println(strArray[i]);
			}
			  
			}
			}
			}
	
