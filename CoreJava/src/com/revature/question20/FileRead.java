package com.revature.question20;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/*
 * FileIO Adventure
 * */
public class FileRead {

	public static void main(String[] args) {
		//file path for Data.txt
		String filename = "src/com/revature/question20/Data.txt";
		
		try { //Try catch block to handle possible FileIO exceptions
			
			//Declare BufferedReader to read from the file
			BufferedReader read = Files.newBufferedReader(Paths.get(filename));
			
			List<String> lines = new ArrayList<>(); //List to store the lines read from file
			
			//Use the lines() function to retrieve all the lines from the file
			//And collect() to convert from a Stream of Strings to a List of strings
			//I used the following reference for this line:
			//https://www.mkyong.com/java8/java-8-stream-read-a-file-line-by-line/
			lines = read.lines().collect(Collectors.toList());
			
			//Loop through the list
			for(String s : lines) {
				//Split each line by the ':'
				String[] data = s.split(":");
				
				//Print the file data to the console
				System.out.print("Name: "+data[0]+" "+data[1]);
				System.out.println();
				
				System.out.print("Age: "+data[2]+" years");
				System.out.println();
				
				System.out.print("State: "+data[3]+" State");
				System.out.println();
				System.out.println();
			}
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
