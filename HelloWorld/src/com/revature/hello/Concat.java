package com.revature.hello;

public class Concat {
	//In Java, there are two ways to concatenate two strings. You can use the concat method or the plus “+” character
	
	/*static String firstName;
	static String lastName;
	static String fullName;
	
	public static void main(String[] args) {
		firstName = "Massiel";
		lastName = "Pimentel";
		
		
		
		fullName = firstName.concat(" ").concat(lastName);
		System.out.println(fullName);
	} 
	*/
	
	public static void main(String args[]){  
		
		String s1 ="Welcome to";   
		//System.out.println(s1);  
		
		s1 = s1.concat(" the world of Strings!");  
		System.out.println(s1);  
		
	//	s1 = s1.concat(" or the plus “+” character");
	//	System.out.println(s1);  
		
		
		
		
		String s2 = "Hello ";
		String s3 = "Massiel,"; 
		String s5 = " welcome to the world of Strings!";		
		
		String s4 = s2.concat(s3).concat(s5);
		System.out.println(s4);  
		
		System.out.println(s2 + s3 + s5 + " Having fun yet?");
		
		}
	
// String concat() concatenates or merges multiple strings
	
}
