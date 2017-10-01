package com.revature.assignment1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.StringTokenizer;

public class DataFromTxtFile {
	
	public static void main(String[] args)
	{	
		String line;
		StringTokenizer st = null;
		
		try ( BufferedReader br = new BufferedReader(new FileReader("src/Data.txt")) )
		{
			while( (line = br.readLine()) != null )
			{
				st = new StringTokenizer(line, ":");
				String[ ] data = {"Name", "Age", "State"};
				
				int i = 0;                     // counter
				
				// Parse Name
				System.out.println( data[i] + ": " + st.nextToken() + " " + st.nextToken() );
				
				// Parse Age and State
				while( st.hasMoreTokens() ) 
				{
					i++;
					System.out.println( data[i] + ": " + st.nextToken() );						
				}
				
				System.out.println();
			}//end-while (read)
		}//end-try
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
