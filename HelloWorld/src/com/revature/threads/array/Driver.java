package com.revature.threads.array;

public class Driver {

	public static void main(String[] args) {
		String[] array = new String[3];
		array[0] = "5";
		array[1] = "two";
		array[2] = "three";
		
		ThreadOne t1 = new ThreadOne(array);
		ThreadTwo t2 = new ThreadTwo(array);
		ThreadThree t3 = new ThreadThree(array);
		
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
		for(String s : array) {
			System.out.println(s);
		}
	}

}
