package corejava;

import java.io.*;

public class CartoonInfo {

	public static void main(String[] args) throws IOException, FileNotFoundException {
		BufferedReader br = new BufferedReader(new FileReader("Data.txt")); //read in file
		String line; 
		String[] split = new String[4];
		while((line = br.readLine()) != null) { //checks to see if line read is null
			split = line.split(":"); //split line read into a string array
			System.out.println("Name: " + split[0] + " " + split[1]);
			System.out.println("Age: " + split[2] + " years");
			System.out.println("State: " + split[3] + " State");
			System.out.println();
		}
		
		
	}

}
