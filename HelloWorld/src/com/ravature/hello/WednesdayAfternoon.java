package com.ravature.hello;

public class WednesdayAfternoon {
	public static void main (String[] args) {
		int i = 3;
		boxing(i);
		
		double d = java.lang.Math.PI;
		boxing(d);
		
		Integer i2 = new Integer(4);
		System.out.println(i2.toString());
		int i3 = unboxing(i2);// can pass an integer object as an argument to a method taking
							//an int primitive because of autounboxing
		
	}
	public static void boxing(Number n) {
		System.out.println(n.toString());
		System.out.println(n.getClass());
	}
	public static int unboxing(int j) {
		System.out.println(j);
		return j;
	}
}
