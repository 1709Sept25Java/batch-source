package com.revature.threads.array;

public class ThreadThree extends Thread{
	String z;
	
	ThreadThree(String z) {
		this.z = z;
	}
	
	public void run() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Thread Three Starting: " + z);
	}
}
