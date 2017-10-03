package com.revature.threads.array;

public class ThreadThree extends Thread{
	String[] array;
	
	ThreadThree(String[] array) {
		this.array = array;
	}
	
	public void run() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Thread Three Starting: " + array[2]);
	}
}
