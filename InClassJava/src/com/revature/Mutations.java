package com.revature.codechallenge1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Mutations {

	static String start;
	static String end;
	static String bankString;
	static String[] bank;

	public static void readFile(String file) {
		try {
			FileReader fReader = new FileReader(file);
			BufferedReader bReader = new BufferedReader(fReader);
			start = bReader.readLine();
			end = bReader.readLine();
			bankString = bReader.readLine();
			bReader.close();
			start = start.substring(1, start.length() - 1);
			end = end.substring(1, end.length() - 1);
			bankString = bankString.substring(1, bankString.length() - 1);
			bank = bankString.split(",");
			for (int i = 0; i < bank.length; i++) {
				if (i == 0) {
					bank[i] = bank[i].substring(1, bank[i].length() - 1);
				} else {
					bank[i] = bank[i].substring(2, bank[i].length() - 1);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static int checkNumMutations(String file) {
		readFile(file);
		int numMutations = 0;
		String currentMutation = start;
		if (start.equals(end)) {
			return 0;
		}

		if (isMutation(start, end) == true) {
			return 1;
		}

		for (int j = 0; j < bank.length; j++) {
			for (int i = 0; i < bank.length; i++) {
				if (isMutation(currentMutation, bank[i]) == true) {
					numMutations = numMutations + 1;
					if (isMutation(bank[i],end)) {
						return numMutations+1;
					}
					currentMutation = bank[i];
					for(int k=i; k<bank.length-1; k++) {
						bank[i]=bank[k];
					}
					i = bank.length;
				}
			}
		}
		return -1;
	}

	public static boolean isMutation(String str1, String str2) {
		int count = 0;
		if (str1.length() != str2.length()) {
			return false;
		}
		char[] arr1 = str1.toCharArray();
		char[] arr2 = str2.toCharArray();
		for (int i = 0; i < arr1.length; i++) {
			if (arr1[i] != arr2[i]) {
				count = count + 1;
			} else {
				continue;
			}
		}
		if (count == 0) {
			return false;
		}
		if (count == 1) {
			return true;
		}
		return false;
	}

}
