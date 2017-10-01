package com.revature.assignment1;

public class Concrete extends Abstract {

	//constructor for concrete class
public Concrete() {
	super();
	
}

	@Override
	public boolean isTheUpper(String str) {
		int length = str.length();
		for(int i = 0; i < length; i++) {
			if (Character.isUpperCase(str.charAt(i))) {
				return true;
			}
			
		}
		return false;
	}

	@Override
	public String upper(String str) {
		return str.toUpperCase(); // turn lower case to upper
	}

	@Override
	public int strToInt(String str) {
		int num = Integer.parseInt(str) + 12; //turn string into int and then add 12
		return num;
	}
}
