package codeChallenges;

import java.util.Scanner;

public class CC10_2 {

	public CC10_2() {
		super();
	}
	
	public void CC10_2(String start, String end, String arr[] bank) {
		
		String arr[] bank = new Array[n];
		int n = ;
		
		
	}
	
	

	public static void main(String[] args) {
		
		//prompt user to input start, end, and bank
		/*Scanner readInput = new Scanner(System.in);
		System.out.println("Input Initial Gene String:");
		String start = readInput.next();
		System.out.println("Input Mutated Gene String:");
		String end = readInput.next(); */
		
		Scanner readArray = new Scanner(System.in).useDelimiter("\\readArray*, \\readArray*");
		System.out.println("Input Bank of Valid Mutations (bank of up to 8 mutations accepted):");
		String bank = readArray.next();
		//I was working on getting the Scanner to read the bank list and 
		//add each item to the bank array when I ran out of time.
		System.out.println(readArray.next());
		System.out.println(readArray.next());
		System.out.println(readArray.next());
		System.out.println(readArray.next());
		System.out.println(readArray.next());
		System.out.println(readArray.next());
		System.out.println(readArray.next());
		System.out.println(readArray.next());
		readArray.close();
		
	}

}
