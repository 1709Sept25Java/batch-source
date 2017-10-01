package com.revature.assignment1;
import java.io.*;

public class Question20 {

	public static void main(String[] args) {
		
		//Filepath based on src directory where Data.txt is saved
		String filename = "src/com/revature/assignment1/Data.txt";
		readFile(filename);
       
	}
	
	//Read File
	static void readFile(String filename) {
		String line;
		try {
			//Read file
		    FileReader fileReader = new FileReader(filename);
		    
		    //Use buffered reader to get the text from the file
		    BufferedReader bufferedReader = new BufferedReader(fileReader);
		    
		    //Iterate through file while there are lines to read 
		    while ((line = bufferedReader.readLine()) != null) {
		    	
		    	//On each line we call the print function to format it as requested
		    	printFormatted(line);
		    }
		} 
		//Catch all the exceptions and print them
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//Print each line in requested format
	public static void printFormatted(String line) {
		
		//The input line has ':' as a delimiter we must remove to get individual words
		String delimiter = ":";
		
		//Split the string by the delimiter and store the words into a String array
		String words[] = line.split(delimiter);
		
		//Print the words in the requested format
		System.out.println("Name: " + words[0] + " " + words[1]);
		System.out.println("Age: " + words[2] + " years");
		System.out.println("State: " + words[3] + " State\n");
	}
}
