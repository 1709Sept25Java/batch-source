package com.revature.assignment1;

public class Question10 {
	public static void main(String[] args) {
		int m1 = 14;
		int m2 = 5;
		
		System.out.println("The minimum value between [" + m1 + ", " + m2 + "] is " + minValue(m1,m2));
		
	}

	static int minValue(int a, int b) {
		//Checks whether a < b
			//if true then return a
			//else return b
		return (a < b) ? a : b;
	}
}
