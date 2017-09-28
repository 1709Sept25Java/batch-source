package com.revature.hello;

import java.util.Scanner;

public class ScannerCalculator {

	public static Number read(String datatype, Scanner sc) {//reads number input according to datatype 
		switch(datatype) {
			case "btye":
				byte num;
				num = sc.nextByte();
				return num;
			case "short":
				short num1;
				num1 = sc.nextShort();
				return num1;
			case "int":
				int num2;
				num2 = sc.nextInt();
				return num2;
			case "long":
				long num3;
				num3 = sc.nextLong();
				return num3;
			case "float":
				float num4;
				num4 = sc.nextFloat();
				return num4;
			case "double":
				double num5;
				num5 = sc.nextDouble();
				return num5;
			default:
				return 0;
		}
	}
	
	public static Number add(Number n1, Number n2, String datatype) {//adds the numbers according to datatype 
		Number n = 0; //n is returned as the sum 
		switch(datatype) {
			case "byte":
				 byte b = (byte) (n1.byteValue() + n2.byteValue());
				 n = b;
				 return n;
			case "short":
				short s = (short) (n1.shortValue() + n2.shortValue());
				n = s;
				return n;
			case "int":
				int i = (int) (n1.intValue() + n2.intValue());
				n = i;
				return n;
			case "long":
				long l = (long) (n1.longValue() + n2.longValue());
				n = l;
				return n;
			case "float":
				float f = (float) (n1.floatValue() + n2.floatValue());
				n = f;
				return n;
			case "double":
				double d = (double) (n1.doubleValue() + n2.doubleValue());
				n = d;
				return n;
		}
		return n;
		
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("What datatype do you want to use? (byte, short, int, long, float, double)");
		String datatype = sc.next(); //scan in datatype as string 
		
		System.out.println("Enter first number to be added.");
		Number n1 = read(datatype, sc); //scan in first number 
		
		System.out.println("Enter second number to be added.");
		Number n2 = read(datatype, sc); //scan in second number 
		
		Number n = add(n1, n2, datatype);
		System.out.println(n);

	}

}
