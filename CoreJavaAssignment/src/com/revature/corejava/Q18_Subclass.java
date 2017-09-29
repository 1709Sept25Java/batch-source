package com.revature.corejava;

public class Q18_Subclass extends Q18_Superclass {
	//abstract class inherited, its three abstract methods must be defined:
	
	public boolean checkUppercase(String str) {
		if(str.toLowerCase()==str) { //check if string is lowercase, return boolean depending on if it is
			return false;
		}
		return true;
	}
	public String toUpper(String str) {
		return str.toUpperCase(); //returns uppercase
	}
	public int addTen(String str) {
		int sum = Integer.parseInt(str)+10; //converts string to int and adds 10
		return sum;
	}
	
	public static void main (String[] args) {
		Q18_Subclass sub = new Q18_Subclass();
		System.out.println(sub.addTen("27"));
		System.out.println(sub.checkUppercase("hEllo"));
		System.out.println(sub.toUpper("hello"));
		//test cases
		
	}
	
}
