package com.revature;

public class Q18_Subclass extends Q18_Superclass {

public boolean checkUppercase(String str) {
		//this checks to see if a string is lowercase
		if(str.toLowerCase()==str) { 
		return false;
		}
		return true;
		}
		//this checks to see if the string is uppercase
	public String toUpper(String str) {
		return str.toUpperCase(); //returns uppercase
		}
		public int addTen(String str) {
		int sum = Integer.parseInt(str)+10; //converts string to int and adds 10
		return sum;
		}
		public static void main (String[] args) {
		Q18_Subclass sub = new Q18_Subclass();
		//these are the test cases
		System.out.println(sub.addTen("87"));
		System.out.println(sub.checkUppercase("revaTure"));
		System.out.println(sub.toUpper("revature"));
		
		}
		}

