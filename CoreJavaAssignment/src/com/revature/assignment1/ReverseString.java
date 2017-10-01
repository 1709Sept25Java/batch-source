package com.revature.assignment1;

public class ReverseString {
	public static void main(String[] args) {
		String str = "tseb eht si ecneicS raluceloM";

	    int len = str.length();
	    for (int i = (len-1); i >= 0; --i) 
	        str += str.charAt(i);
	    str = str.substring(len);

	    System.out.println(str);
	}

}
