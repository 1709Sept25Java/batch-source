package com.revature.assignment1;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;


public class ArrayListPalindromes {
	private static ArrayList<String> pal = new ArrayList<String>();
	 
	private static ArrayList <String> palindromes (ArrayList<String> list )
	{
		int num,
		counter;
		
		for (String str: list) 
		{
			if (str.length()%2==0)
			{
				num = str.length() /2;
				counter = 0;
				
				for (int i=0; i < num; i++)
				{
					if (str.charAt(i) == str.charAt(str.length() -i -1))
						counter++;
					if (counter == num)
						pal.add(str);
				}
			}//end of if statement
			else 
			{
			num = (str.length()-1) /2;	
			counter = 0;
			for (int j = 0; j < num; j++)
			{
				if (str.charAt(j) == str.charAt(str.length() - j -1))
					counter++;
				if (counter == num)
					pal.add(str);
				}
					
			}
			
		}
		return pal;
	}



public static void main (String [] args)
{ 

	ArrayList<String> arr = new ArrayList<String>
	( 
		Arrays.asList("karan",
					 "madam",
					 "tom",
					 "civic",
					 "radar",
					 "sexes",
					 "jimmy",
					 "kayak",
					 "john",
					 "refer",
					 "billy",
					 "did"
		)
	);
	
	
	try(BufferedWriter out = new BufferedWriter(new FileWriter("src/palindromes.txt")) )
	{
		Iterator<String> iter = arr.iterator();
		
		while( iter.hasNext() )
			out.write( "\""+ iter.next() + "\", " );
			
		
	} 
	catch (IOException e) 
	{
		e.printStackTrace();
	}
	
	
	System.out.println("ArrayList: " + arr);
	System.out.println("ArrayList palindromes: " + palindromes(arr) );
}
}


