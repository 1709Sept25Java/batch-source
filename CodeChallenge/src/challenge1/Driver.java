package challenge1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Driver {

	public static void main(String[] args) throws IOException { //exception to deal with readLine() in case file is empty
		try { //try-catch to handle exception where file could not be found 
			BufferedReader br = new BufferedReader(new FileReader("bank.txt"));
			String start = br.readLine(); //start string is first line
			String end = br.readLine(); //end string is second line
			String str = br.readLine(); //first string in bank
			String[] bank = new String[3];
			while(str != null) { //add all bank strings into bank[]
				for(int i = 0; i < bank.length; i++) {
					bank[i] = str;
					str = br.readLine();
				}
			}
			int mutations = StringMutation.minMutation(start, end, bank);
			System.out.println(mutations);
		} catch (FileNotFoundException e) { //handles exception
			e.printStackTrace();
		}
		

	}

}
