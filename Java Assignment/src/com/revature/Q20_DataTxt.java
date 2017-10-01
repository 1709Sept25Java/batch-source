package com.revature;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.StringTokenizer;

public class Q20_DataTxt {
	public static void main(String[] args)
	{	
		String line;
		StringTokenizer st = null;
		
		try ( BufferedReader br = new BufferedReader(new FileReader("batch-source/Java Assignment/src/com/revature/data.txt")) )
		{
			while( (line = br.readLine()) != null )
			{
				st = new StringTokenizer(line, ":");
				String[] data = {"Name", "Age", "State"};
				
				int i = 0;                     
				System.out.println( data[i] + ": " + st.nextToken() + " " + st.nextToken() );

				while( st.hasMoreTokens() ) 
				{
					i++;
					System.out.println( data[i] + ": " + st.nextToken() );						
				}
				
				System.out.println();
			}
		}
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
