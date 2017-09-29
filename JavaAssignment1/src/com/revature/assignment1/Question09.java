package com.revature.assignment1;

import java.util.ArrayList;

public class Question09 {

	public static void main(String[] args) {
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		for(int i=1; i<=100; i++) {
			numbers.add(i);
		}
		for (Integer i:numbers) {
			System.out.println(i);
		}
	}
	

}
