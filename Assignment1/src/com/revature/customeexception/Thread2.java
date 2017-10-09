package com.revature.customeexception;

public class Thread2 extends Thread {

	ArrayofStrings getArray = new ArrayofStrings();
	public static void main(String[] args) {
		
		 (new Thread(new Thread2())).start();
	}

}
