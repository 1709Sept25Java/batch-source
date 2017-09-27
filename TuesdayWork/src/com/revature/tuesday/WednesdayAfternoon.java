package com.revature.tuesday;

public class WednesdayAfternoon {

	public static void main(String[] args) {
		int i= 3; //primitive value about to be boxed into its wrapper class "Integer"
		boxing (i);
		Integer i2 = new Integer(4);
		System.out.println(i2);
		int i3 = unboxing(i2); //can
		
		double d = java.lang.Math.PI;
		boxing(d);
		
	}
		
		public static void boxing(Number n){
			
			System.out.println(n.toString());
			System.out.println(n.getClass());
		}
		
		public static int unboxing (int j) {
			  System.out.println(j);
			  return j;
			  
			
		}

	
	


}
