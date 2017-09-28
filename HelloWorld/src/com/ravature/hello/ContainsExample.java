package com.ravature.hello;

public class ContainsExample {

public static void main(String [] args) {
	String str1 = "we learn java here";
	String str2 = "java";
	System.out.println("original String "+ str1);
	System.out.println(" the subString "+ str2 + " is ");
	System.out.println(str1.contains(str2));
}

}
