package com.revature.assignment1;

import java.util.Scanner;

public class MainClassforAbstractMethod {

	public static void main(String[] args) {

		ConcreteSubClass main = new ConcreteSubClass();

		Scanner in = new Scanner(System.in);
		System.out.println("Enter a string to check for uppercase characters: ");
		String s1 = in.nextLine();
		System.out.println(main.checkUpperChar(s1));

		System.out.println("Enter a string to convert its lowercases to uppercase");
		String s2 = in.nextLine();
		main.convertChar(s2);

		String s3 = "1000";
		main.convertInputStr(s3);

		in.close();
	}

}
