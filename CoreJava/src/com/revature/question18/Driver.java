package com.revature.question18;

public class Driver {

	public static void main(String[] args) {
		
		String str1 = "no uppercaSes";
		String str2 = "don't blink";
		String str3 = "23";
		
		StringFun s = new StringFun();
		
		System.out.println("There are uppercase letters in '"+str1+"': "+s.checkUpper(str1));
		
		System.out.println(str2+" becomes "+s.makeUpper(str2));
		
		s.addTen(str3);
		
	}
	
}
