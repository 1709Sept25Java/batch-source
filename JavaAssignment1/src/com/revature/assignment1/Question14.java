package com.revature.assignment1;

import static java.lang.Math.sqrt;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Question14 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 3;
		int x = 25;
		String s1 = "I am learning Core Java"; 
		
		//https://stackoverflow.com/questions/5287538/how-can-i-get-the-user-input-in-java
		
		switch(n) {
			case 1: 
				sqrt(x);
				break;
			case 2:
				DateFormat df = new SimpleDateFormat("MM/dd/yy");
			    Date dateobj = new Date();
			    System.out.println(df.format(dateobj));
			    break;
	
			case 3:
				String [] words = new String[5];
				for(String w:s1.split(" ")){
					System.out.println(w);
				}
				break;

				
				
		}
	}
	

}
