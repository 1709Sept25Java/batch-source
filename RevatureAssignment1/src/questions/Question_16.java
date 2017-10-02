package questions;

import java.util.Scanner;
/**Write a program to display the number of characters for a string input. 
 * The string should be entered as a command line argument using (String [ ] args).
 */

public class Question_16 {

	public static void main(String[] args) 
	{
		length();

	}
	public static void length() {
		Scanner scan= new Scanner(System.in);
		System.out.println("Type in a String, and the program will calculate its length.");
		String input= scan.nextLine();
		System.out.println(input.length());
	}

}
