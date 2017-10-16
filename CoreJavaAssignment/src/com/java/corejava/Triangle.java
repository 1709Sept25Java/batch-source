package com.java.corejava;

public class Triangle {

	public static void main(String[] args) {
		
        for(int i = 0; i <= 4; i++){ // prints 4 rows 
        	
           for(int j = 0; j < i; j++) // prints 4 columns
             
        	   System.out.print((i+j) % 2 == 0 ? "1 " : "0 "); //if the remainder of the indexes == 1, print 1, otherwise print 0 
           
           System.out.print("\n"); // print loops on next line 
        }
		
		
		
		
		
		
		
		
	} 
		

}



/* Display the triangle on the console as follows using any type of loop.  Do NOT use a simple group of print statements to accomplish this.
   0
   1 0
   1 0 1
   0 1 0 1 */
