package com.revature.assignment1;

public class ConcreteAbs {
	
	public static void main (String [] args) {
		String str = "Jennifer";//string to check and change uppercase
		String num = "12";//string to to turn into int
		Concrete c = new Concrete(); //create a concrete method
		System.out.println("The are uppercase in the string " + str + ": " + c.isTheUpper(str));
		System.out.println(c.upper(str));
		System.out.println(c.strToInt(num));
	}

}
