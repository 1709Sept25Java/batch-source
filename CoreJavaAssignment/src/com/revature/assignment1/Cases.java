package com.revature.assignment1;

import java.util.*;

public class Cases {
	public static void main(String[] args) {
		String str = "split";
		switch(str) {//variable to check with cases 
		case "sqrt":
			int num = 16;
			System.out.println("Square root of " + num + " is " + Math.sqrt(num));//print out square root of 16
			break;
		case "date":
			Date today = Calendar.getInstance().getTime();//Monday's date
			System.out.println("today's date is " +today);
			break;
		case "split":
			String split = "I am learning Core Jave ";
			String[] ar = split.split(" ");//split string using space
			int length = ar.length;
			for (int i = 0; i< length; i++) {
				System.out.println(ar[i]);
			}
		}
	}

}
