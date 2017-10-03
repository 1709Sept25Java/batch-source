package com.revature.threads.array;

public class ThreadOne extends Thread {
	
	String[] array;
	
	ThreadOne(String[] array) {
		this.array = array;
	}
	
	public void run() {
		double b = Integer.parseInt(array[0]);
		double sqr = b * b; 
		array[0]=Double.toString(sqr);
		System.out.println("Thread One Starting: " + sqr);
		
	}
}
