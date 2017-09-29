package com.revature.assignment1;

public class Question06 {

	public static void main(String[] args) {

		System.out.println(isEven(67));
	}
	public static Boolean isEven(int n) {
		int evenCheck = n/2;
		if (evenCheck*2 == n) {
			return true;
		}
		return false;
	}
}
