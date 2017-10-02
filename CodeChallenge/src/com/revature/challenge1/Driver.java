package com.revature.challenge1;

import java.util.ArrayList;

public class Driver {

	public static void main(String[] args) {
		String start = "AACCGGTT";
		//String end = "AACCGGTA"; //1 mutation
		String end = "AAACGGTA"; //2 mutations
		ArrayList<String> bank = new ArrayList<String>();
		bank.add("AACCGGTA");
		bank.add("AACCGCTA");
		bank.add("AAACGGTA");
		
		AnalyzeMutations analyze = new AnalyzeMutations();
		//analyze.minimumMutations(start, end, bank);
		System.out.println("There are " + analyze.minimumMutations(start, end, bank) + " mutations"); 	
	
	}
}
