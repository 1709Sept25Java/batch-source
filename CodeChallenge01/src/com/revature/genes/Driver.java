package com.revature.genes;

import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		
		String filename = "";
		Scanner sc =new Scanner(System.in);
		
		System.out.println("Please enter a start string: ");
		String start = sc.nextLine();
		
		System.out.println("Please enter an end string: ");
		String end = sc.nextLine();
		
		System.out.println("Please enter possible mutations with a space in between");
		String inBank =sc.nextLine();
		String[] bank = inBank.split("\\s");
		
		Mutations m = new Mutations();
		int changes = m.minMutations(start, end, bank, 0);
		System.out.println("Min mutations: "+ changes);
		
	}
	
}
