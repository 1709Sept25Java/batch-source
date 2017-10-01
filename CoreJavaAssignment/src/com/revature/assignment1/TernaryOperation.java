package com.revature.assignment1;
import java.util.Scanner;
public class TernaryOperation {

	public static void main(String[] args) {
		int a, b, c;
		Scanner s = new Scanner(System.in);
		System.out.println("Enter two number: ");
		
		a = s.nextInt();
		b = s.nextInt();
		c = b < (b < a ? a:b) ? b:((a < b) ? a : b);
		
		System.out.println("Smallest number is : "+c);
		
	}

}
