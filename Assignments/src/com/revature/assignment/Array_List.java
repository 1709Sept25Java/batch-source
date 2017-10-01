package com.revature.assignment;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;


public class Array_List {
	
private static ArrayList<String> ar = new ArrayList<String>();
	
	
	private static ArrayList<String> palindromes( ArrayList<String> list )
	{
		int comparsions,counter ;
		
		for (String str : list)
		{
			if (str.length()  % 2 == 0)
			{
				comparsions = str.length() / 2;
				counter = 0 ;
				
				for(int i = 0; i < comparsions ; i++) {
					
					if( str.charAt(i) == str.charAt(str.length() - i -1))
						
						counter++ ;
					
					if(counter == comparsions)
						ar.add(str);
				}
			}// end of if 
			else
			{
				comparsions = (str.length() - 1) /2 ;
				counter = 0 ;
				for (int j = 0; j < comparsions; j++)
				{
					if( str.charAt(j) == str.charAt(str.length() - j - 1))
						counter++;
					
					if(counter == comparsions)
						ar.add(str);
				}
			}// end else
				
				}
		return ar;
		
			}// end method
		

	public static void main(String[] args) {
		
	
		ArrayList<String> array = new ArrayList<String>
		(
				Arrays.asList(" Karan", " madam", " tom"," civic", "radar",
						" sexes", " Jimy", " kayak", " john ", "refer ",
						" billy", " did")
				);
		
		
		System.out.println( " ArrayList: " + array);
		System.out.println(" ArrayList palindromes: " + palindromes(array));
	}
}


