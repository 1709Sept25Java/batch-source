package com.revature.assignment1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadPrintfromFile {

	public static void main(String[] args) throws IOException {
							
							readFile();
	}

	public static void readFile() throws IOException {

		BufferedReader reader = new BufferedReader(new FileReader("Data.txt"));
		String txtLine;
		while ((txtLine = reader.readLine()) != null) {
			String [] str = txtLine.split(":");
			System.out.println("Name: " + str[0] +" "+ str[1]);
			System.out.println("Age: " + str[2] + " years");
			System.out.println("State: " + str[3] + " State\n");
		}

		reader.close();

	}
}
