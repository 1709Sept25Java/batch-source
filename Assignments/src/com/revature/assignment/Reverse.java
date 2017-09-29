package com.revature.assignment;

public class Reverse {

	public static void main(String [] args){
		
		String reverse = " erutaveR";
		for (int i = 0; i < reverse.length(); i++) {
		    reverse = reverse.substring(1, reverse.length() - i)
		        + reverse.substring(0, 1)
		        + reverse.substring(reverse.length() - i, reverse.length());
		 }
		 System.out.println(reverse);
	}
}
