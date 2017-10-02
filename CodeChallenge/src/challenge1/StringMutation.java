package challenge1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class StringMutation {
	
	public static boolean isValid(String end, String[] bank) { //checks to see if end string is included in the bank
		for(String str : bank) {
			if(end.equals(str)) {
				return true;
			}
		}
		 return false; //if it is not included, it means that there are no such mutation
	}
	
	public static int charDifference(String s1, String s2) { //returns how many char mutations there are between two strings
		int count = 0;
		int length = (s1.length() < s2.length()) ? s1.length() : s2.length(); //checks to see which string is shorter to avoid exception being thrown
		for(int i = 0; i < length; i++) {
			if(s1.charAt(i) != s2.charAt(i)) {
				count++;
			}
		}
		return count;
	}
	
	public static int minMutation(String start, String end, String[] bank) {
		int count = 0;
		if(start.equals(end)) {//start and end string are the same
			return 0;
		}
		else if(!isValid(end, bank)) { //no such mutation is possible - end string is not in bank
			return -1;
		}
		else {
			while(charDifference(start, end) != 0) { //continue loop if start and end string are not the same
				for(int i = 0; i < bank.length; i++) { //find string with only 1 mutation from end string
					int index;
					for(index = 0; index < bank.length; index++) {//find index of end string
						if(end.equals(bank[index])) {
							break;
						}
					}
					if(charDifference(end, bank[i]) == 1) {
						count++; 
						end = bank[i]; //mutation string becomes new end string
						bank[index] = ""; //get rid of previous end string in bank 
					}
				}
				break;
			}
		}
		return count; //return number of mutation 
	}
	
}
