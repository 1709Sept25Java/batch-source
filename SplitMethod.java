package com.revature.hello;
	
	public class SplitMethod{
		
		public static void main(String args[]){
		String str5 = "java string split method";
		String[] words = str5.split("\\s"); //splits the string based on whitespace, can also do an empty space 
		
		for(String w:words){
		System.out.println(w);
		
		}
		
		}}
		
	//split method splits the string against a given expression and returns a char array. there are two split signatures
	//in the split method. there's the regular expression and the limit. the limit returns all the strings in the array.
	// If it is 0, it will return all the strings matching the regular expression. 
	
	//Arrays utility class, look at the methods 
	
	//string object and literals
	