package com.java.corejava;

public class Fibonacci {
	

	public static void main(String[] args) { // each subsequent number is the sum of the previous two numbers.
		
		int a = 0, b = 0, c = 1; // sequence starts at 0
		
        for(int i = 1; i <= 25; i++){
           a = b; // value assignments change and loop 25 times 
           b = c;
           c = a + b; 
 
		System.out.print(a +" ");
        }
		
	}
      

}