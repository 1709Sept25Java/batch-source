package com.revature.hello;

public class WednesdayAfternoon {

	public static void main(String[] args) {
		int i = 3; //primitive value about to be boxed into its wrapper class "Integer"
		boxing(i);
		
		Integer i2 = new Integer(4); 
		System.out.println(i2.toString());
		int i3 = unboxing(i2); //can pass an Integer object as an argument to 
							  // a method taking an int primitive because of autounboxing
	
		double d = java.lang.Math.PI; 
		boxing(d); 
		//funWithStrings();
		funWithArrays();
	}
	
	public static void boxing(Number n) {
		System.out.println(n.toString());
		System.out.println(n.getClass());
	}
	
	public static int unboxing(int j) {
		System.out.println(j);
		return j;
	}
	
	public static void funWithStrings() {
		
		String str2 = "example";
		if (str2.isEmpty()) {
			
			
			
		}
		
		//format
		String str3 = "hello";
		System.out.println(String.format("%s World", str3));
		
		//toUppercase
		String str4 = "apple";
		System.out.println(str4.toUpperCase());
		
		//split
		String str5 = "java-string-split-method";
		String[] words = str5.split("-");
		for (String w: words) {
			System.out.println(w);
		}
		
		//contains
		String str6 = "we learn java here";
		String str7 = "java";
		System.out.println("original string " + str6);
		System.out.println("substring " + str7);
		System.out.println(str6.contains(str7));
		
		//concat 
		String str8 = "welcome to ";
		str8 = str8.concat("to the world of strings");
		//str8 is being referenced to a new string literal
		System.out.println(str8);
		
		//substring
		String str9 = "substring is a subset of another string";
		System.out.println(str9.substring(15, 21));
		
		//trim
		String str10 = "            brave is the best way to be               ";
		System.out.println(str10);
		System.out.println(str10.trim());
		
		//getChars
		String str11 = "testing";
		char [] a = new char[4];
		str11.getChars(1, 4, a, 0);
		System.out.println(a);
		
		//compareTo
		String str12 = "alpha";
		String str13 = "bravo";
		System.out.println(str12.compareTo(str13));
		System.out.println(str13.compareTo(str12));
		System.out.println(str12.compareTo("alpha"));
		
		//StringBuilder reverse
		String str14 = "erutaver";
		StringBuilder sb = new StringBuilder(str14);
		System.out.println(sb.reverse());
		
		//Character Array 
		
		//string objects and literals 
		char[] helloArray = {'h', 'e', 'l', 'l','o'};
		String helloString = new String(helloArray);
		System.out.println(helloString);
		String otherHelloString = "hello";
		System.out.println(helloString == otherHelloString); //compares reference
		System.out.println(helloString.equals(otherHelloString)); //compares content
		
		String thirdHelloString = new String("hello");
		System.out.println(thirdHelloString == otherHelloString); //compares reference
		System.out.println(thirdHelloString.equals(otherHelloString)); //compares content
		
	}
	
	public static void funWithArrays() {
		//ways to declare arrays
		int[] intArray1D = {5,6,7};
		int[] intArray1D2 = new int[7];
		int intArray1D3[] = new int[7]; //this is correct but horrible
		
		//we are not limited to one dimmension
		int[][] intArray2D = {{5},{6},{7,8}};
		int[][] intArray2D2 = new int[3][4];
		
		//array traversal
		System.out.println(intArray2D.toString());
		//System.out.println(Arrays.toString(intArray2D));

		for (int i=0; i<intArray2D.length; i++) {
			for (int j=0; j<intArray2D[i].length; j++) {
				System.out.print(intArray2D[i][j]+" ");
			}
			System.out.println();
		}
		//if we try to access elements beyond the array's size, we get 
		//ArrayIndexOutOfBoundsException
		System.out.println(intArray1D[7]);
		
	}
	
	
	
}

/* 
 * Implementation + explanation of method in java document
 * What is + how to use it + example
 * indexOF String Class
*/