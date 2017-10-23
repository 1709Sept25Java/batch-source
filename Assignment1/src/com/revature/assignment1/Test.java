package com.revature.assignment1;

import java.util.Scanner;
import java.util.Stack;

public class Test {

	public static void main(String[] args) {

		/*
		 * InterfaceOperation test = new InterfaceOperation();
		 * 
		 * Scanner input = new Scanner(System.in);
		 * System.out.println("Enter the first number for calculation: "); Double n1 =
		 * input.nextDouble();
		 * System.out.println("Enter the second number for calculation: "); Double n2 =
		 * input.nextDouble();
		 * 
		 * System.out.println("Addition : " + test.addition(n1, n2));
		 * System.out.println("Subtraction : " + test.subtraction(n1, n2));
		 * System.out.println("Multiplication : " + test.multiplication(n1, n2));
		 * System.out.println("Division : " + test.division(n1, n2)); input.close();
		 */
		
		sortArray();

	}

	public static void sortArray() {
		String bracketString = " ";
		char[] charB = bracketString.toCharArray();
		
		for (int i = 0; i < bracketString.length(); i ++) {
			
			char chrBracket = charB[i]; 
			 Stack stack = new Stack();
			char [] openBrackets = {'(', '{', '['};
			char [] closeBrackets = { ')', '}', ']'};
				
				if( openBrackets.index(chrBracket) >= 0){
							stack.push(chrBracket);
	   
	   }  else if (closeBrackets.indexOf(chrBracket) >= 0){
		         mapBrackets = openBrackets[closeBrackets.indexOf(chrBracket)];
				 
				 if ((stack.size() !=0) || (stack.pop() == mapBrackets)) {
						return true;
					  ;
						break;
							 }
						}	else {
								continue;
								
						}
	}
		
		 
		

	}
}
