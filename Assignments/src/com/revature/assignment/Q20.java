package com.revature.assignment;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
public class Q20 {
	
	public static void main(String[] args) {
		
		String line;
		StringTokenizer str = null;

try ( BufferedReader br = new BufferedReader(new FileReader("src/Data.txt")) ) {
		while( (line = br.readLine()) != null )
		{
			str = new StringTokenizer(line, ":");
			String[] data = {"Name", "Age", "State"};
			
			int i = 0;                     // counter
			
			// Parse Name
			System.out.println( data[i] + ": " + str.nextToken() + " " + str.nextToken() );
			
			// Parse Age and State
			while( str.hasMoreTokens() ) 
			{
				i++;
				System.out.println( data[i] + ": " + str.nextToken() );						
			}
			
			System.out.println();
		}//end-while (read)
	}
	
catch(FileNotFoundException e)
{
	e.printStackTrace();
}
catch(Exception e)
{
	e.printStackTrace() ;
	}
}
}


