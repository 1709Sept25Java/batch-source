package com.revature.assignment1;
import java.io.*;

public class Question20 {

	public static void main(String[] args) {

		String fileName = "src/com/revature/assignment1/Data.txt";
        String line = null;
        try {
	        FileReader fileReader = new FileReader(fileName);
	        BufferedReader bufferedReader = new BufferedReader(fileReader);
	        while ((line = bufferedReader.readLine()) != null) {
	        	printFormatted(line);
	        }
        } catch (FileNotFoundException f) {
        	System.out.println("File not found");
        } catch (IOException i) {
        	System.out.println("Couldn't read file");
        }
        //finally with close file should go here
	}
	
	public static void printFormatted(String line) {
		String delimiter = ":";
		String words[] = line.split(delimiter);
		System.out.println("Name: " + words[0] + " " + words[1]);
		System.out.println("Age: " + words[2] + " years");
		System.out.println("State: " + words[3] + " State");
		System.out.println();
		

	}
}
