package com.revature.corejava;

public class Q10_Minimum {

	public static int min(int a, int b) {
		return (a < b) ? a : b;  // compares, a and b -- if condition of (a<b) is true
	}							// returns the int after the '?' (a)
								// otherwise, the method returns the int after the ':' (b)

	public static void main(String[] args) {
		System.out.println(min(4, 3));
		System.out.println(min(92, 103));
		System.out.println(min(0, 3));
	} //test cases

}
