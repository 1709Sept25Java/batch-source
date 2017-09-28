package com.revature.hello;

public class WednesdayAfternoon {

	public static void main(String[] args) {
		
		int i = 3; //primitive value about to be boxed into its wrapper class "Integer"
		boxing(i);
		
		double d = java.lang.Math.PI;
		boxing(d);
		
		Integer i2 = new Integer(4);
		System.out.println(i2);
		int i3 = unboxing(i2); //can pass an Integer object as an argument to a method taking
								// an int primitive because of autoboxing 
		
		//string objects and literals 
		char[] helloArray = {'h', 'e', 'l', 'l', 'o'};
		String helloString = new String(helloArray);
		
		
	}
	
	public static void boxing(Number n) {
		System.out.println(n.toString());
		System.out.println(n.getClass());
	}
	
	public static int unboxing(int j) {
		System.out.println(j);
		return j;
	}
	
	public static void funWithArrays() {
		//ways to declare arrays
		int[] intArray1D = {5,6,7};
		int[] intArray1D2 = new int[7];
		int intArray1D3[] = new int[7]; //this is correct but horrible 
		
		//we are not limited to one dimension 
		int[][] intArray2D = {{5}, {6}, {7, 8}};
		int[][] intArray2D2 = new int[3][4];
		
		//array traversal 
		//[i][j]
		//[i] = intArray2D.length - rows
		//[j] = intArrat2D[i].length - columns 
		
		//if we try to access elements beyond the array's size, we get 
		//ArrayIndexOutOfBoundsException
		}
	}
	

