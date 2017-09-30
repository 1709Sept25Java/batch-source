package com.revature.question18;

public class StringFun extends Stringy {

	@Override
	public boolean checkUpper(String str) {
		
		for(int i=0;i<str.length();i++) {
			if(Character.isUpperCase(str.charAt(i))) {
				return false;
			}
		}
		
		return true;
	}

	@Override
	public String makeUpper(String str) {
		
		String allUpper = str.toUpperCase();
		
		return allUpper;
	}

	@Override
	public void addTen(String str) {
		
		int n = Integer.parseInt(str) +10;
		
		System.out.println(str+" + 10 = "+n);
		
	}

}
