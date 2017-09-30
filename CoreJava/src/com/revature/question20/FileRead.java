package com.revature.question20;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FileRead {

	public static void main(String[] args) {
		
		String filename = "src/com/revature/question20/Data.txt";
		
		try {
			
			BufferedReader read = Files.newBufferedReader(Paths.get(filename));
			
			List<String> lines = new ArrayList<>();
			
			lines = read.lines().collect(Collectors.toList());
			
			for(String s : lines) {
				String[] data = s.split(":");
				
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
