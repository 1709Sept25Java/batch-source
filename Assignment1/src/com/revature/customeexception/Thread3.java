package com.revature.customeexception;

public class Thread3 implements Runnable {

	ArrayofStrings getArray = new ArrayofStrings();
	public static void main(String[] args) {
		
		
	}

	@Override
	public void run() {
			
		String[] a = new String [3];
		for (int i=0; i < a.length; i++) {
			System.out.println(a[0]);
		}
	}

}
