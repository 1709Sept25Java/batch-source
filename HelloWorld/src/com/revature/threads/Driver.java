package com.revature.threads;

public class Driver {

	public static String[] array = {"5", "two","three"};
	
	public static void main(String[] args) {
		
		ThreadOne t1 = new ThreadOne(array[0]);
		ThreadTwo t2 = new ThreadTwo(array[1]);
		ThreadThree t3 = new ThreadThree(array[2]);
		
		t1.start();
		t2.start();
		t3.start();
		
		try {
			t1.join();
			t2.join();
			t3.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("...all threads have completed");
		
	}

}