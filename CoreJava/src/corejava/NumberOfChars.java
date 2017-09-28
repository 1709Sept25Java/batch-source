package corejava;

import java.util.*;

public class NumberOfChars {

	public static int numOfChars(String str) {
		int length = str.length();
		int count = 0;
		for(int i = 0; i < length; i++) {//traverse through string 
			if(str.charAt(i) != ' ') {//find the chars, ignore spaces 
				count++; //if its a character, increment count 
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a string.");
		String str = sc.nextLine();
		int num = numOfChars(str);
		System.out.println(num);
		sc.close();

	}

}
