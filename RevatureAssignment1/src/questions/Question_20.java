package questions;

import java.io.*;
import java.util.ArrayList;

/**
Write a program that would read from the file and print it out to the screen in the following format:
Name: Mickey Mouse
Age: 35 years
State: Arizona State
 */
public class Question_20 
{
	private String str;
	public static void main (String[]args) 
	{	
		
		reader();
	}
	
	public static void reader() 
	{
		//seperated by :
		Question_20 a= new Question_20();
		
	   try {
	            BufferedReader in = new BufferedReader
	            /*where my physical path file exactly is... 
	            need to change it to a virtual path for it to be access by others 
	            */
	            		(new FileReader("C:\\Users\\jinli\\OneDrive\\Documents\\GitHub\\batch-source\\RevatureAssignment1\\src\\questions\\Data.txt"));
	            a.str= in.readLine();
	                //test seeing first line of file: System.out.println(a.str);
	            in.close();
	        } 
	       catch(FileNotFoundException fnfe){
	    	   System.out.println("File not found!");
	    	   fnfe.printStackTrace();
	       }
	       catch (Exception e) {
	    	   //handle IOException and other Exceptions
	            System.out.println("File Error");
	            e.printStackTrace();
	       }
	   fileString(a.str);
	}
	
	public static String fileString(String rd) 
	{	
		/*based on where ":" is, finds the index of it
		then looks for the substring of the next
		used arraylist to get and store the placements of ":" 
		*/	
		ArrayList<Integer> list = new ArrayList<Integer>();
		char charIndex = ':';
		for(int i = 0; i < rd.length(); i++){
		    if(rd.charAt(i) == charIndex){
		       list.add(i);
		    }
		}
		
		/**test seeing lists indexes: System.out.println(list);
		put in the Name, Age, State
		added +1 to the ones after the first name to get rid of the ":"
		**/
		System.out.println("Name: "+rd.substring(0, list.get(0))
				+" "+ rd.substring(list.get(0)+1, list.get(1))
				+"\nAge: "+rd.substring(list.get(1)+1,list.get(2))
				+"\nState: "+rd.substring(list.get(2)+1,rd.length()));
		
		return rd;
	}

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

}
