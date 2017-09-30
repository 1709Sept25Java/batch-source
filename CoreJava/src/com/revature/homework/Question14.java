package com.revature.homework;

import java.time.LocalDate;

public class Question14 {
	
	public static void main(String[] args) {
		
		//int to control switch case
		int i= 3;
		
		switch(i) {
			case 1:
				//Math Square Root function
				System.out.println("Square room of 16 is: "+ Math.sqrt(16.0));
				break;
			case 2:
				//Find today's date using LocalDate
				LocalDate today=LocalDate.now();
				System.out.println(today);
				break;
			case 3:
				//use .split("\\s") to split String based on whitespace
				String str = "I am learning Core Java";
				String[] torn = str.split("\\s");
				for(String s : torn) {
					System.out.println(s);
				}
		}
		
	}

}
