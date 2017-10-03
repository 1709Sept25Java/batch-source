package com.revature.threads.array;

public class Driver {

	public static void main(String[] args) {
		String[] array = new String[3];
		array[0] = "5";
		array[1] = "two";
		array[2] = "three";
		
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
