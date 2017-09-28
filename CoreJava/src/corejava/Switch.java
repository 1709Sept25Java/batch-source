package corejava;

import java.util.*;

public class Switch {

	public static void main(String[] args) {
		String str = "split";
		switch (str) {//variable to check with the cases
			case "sqrt": 
				int num = 25;
				System.out.println("Square root of " + num + " is " + Math.sqrt(num)); //print out sqrt of 25
				break;
			case "date":
				Date today = Calendar.getInstance().getTime(); //find todays date
				System.out.println("Today's date is " + today);
				break;
			case "split":
				String split = "I am learning Core Java";
				String[] ar = split.split(" "); //split string using spaces
				int length = ar.length;
				for(int i = 0; i < length; i++) {
					System.out.println(ar[i]);
				}
		}

	}

}
