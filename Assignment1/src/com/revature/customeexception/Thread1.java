package com.revature.customeexception;

public class Thread1 implements Runnable {

	ArrayofStrings getArray = new ArrayofStrings();
	
	public static void main(String[] args) {
		
		 (new Thread(new Thread1())).start();
	}

	@Override
	public void run() {
		
		Object[] arr = ;
		System.out.println(getArray.listofArray(arr [0]));
	}

}
