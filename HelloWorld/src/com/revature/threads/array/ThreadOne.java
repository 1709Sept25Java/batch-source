package com.revature.threads.array;

public class ThreadOne extends Thread {
	
	String x;
	
	ThreadOne(String a) {
		this.x = a;
	}
	
	public void run() {
		double b = Integer.parseInt(x);
		double sqrt = b * b; 
		System.out.println("Thread One Starting: " + sqrt);
		
	}
}
