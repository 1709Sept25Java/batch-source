package com.revature.corejava;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Q14_SwitchCase {
	
	public static void threeCases(int i) { 
		if (i>3 || i<1) {
			System.out.println("'threeCases' can only take int arguments 1, 2, and 3");
		} // prints an error statement if an invalid case is an argument 
		switch (i) { //switch case for valid arguments 
			case 1:
				System.out.println("The square root of 196 is "+Math.sqrt(196));
				break; 
			case 2: 
				System.out.println(DateTimeFormatter.ofPattern("MM/dd/yyyy").format(LocalDate.now()));
				break; //prints nicely formatted date
			case 3:
				String str = "I am learning Core Java"; //creates string
				String[] strArr = str.split("\\s"); //splits at each space character, and stores in an array
				System.out.print("[ "); //prints array nicely
				for (String a : strArr) { 
					if(a.equals(strArr[strArr.length-1])) {
						System.out.print(a);
						continue;
					}
					System.out.print(a + ", ");	//prints each element in the array
				}
				System.out.println(" ]");
				break;

		}	
	}
	

	public static void main(String[] args) {
		threeCases(1);
		threeCases(2);
		threeCases(3);
		threeCases(0);
		//test cases
	}

}
