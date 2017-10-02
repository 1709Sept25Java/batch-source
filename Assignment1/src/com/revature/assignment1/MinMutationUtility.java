package com.revature.assignment1;

import java.util.ArrayList;
import java.util.Arrays;


public class MinMutationUtility {

	public static int minMutationNeeded() {

		String start = " ";
		String end = " ";
		String [] bank = {};
		
		ArrayList<String> bankList = new ArrayList<String>();
		bankList.addAll(Arrays.asList(bank));
		
		for ( String str : bankList) {
			if(!start.equals(end)) {
				bankList.add(str);
				
				System.out.println(bankList.size());
				
			} return 0;
				
		}
	}

	public static int checkStartEnd() {
		String start = " ";
		String end = " ";
		if (!start.equals(end)) {

			return -1;
		}

		return 0;

	}
}
