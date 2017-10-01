package com.revature.assignment1;

public class Question05 {

	public static void main(String[] args) {
		String str = "Something";
		int idx = 5;
		substring(str,idx);
		System.out.println("Substring of '" + str + "' within index [0," + idx +"]: " +substring(str,idx));
		
	}
	
	public static String substring(String str, int idx) {
		//Create character array of length idx
		char[] array = new char[idx];

		//Iterate through only idx character of string 
		for (int i=0; i<idx-1; i++) {
			array[i] = str.charAt(i);
		}
		
		//Return substring
		return String.valueOf(array);
	}

}
