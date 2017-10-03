package com.revature.threads;

public class ThreadOne extends Thread {
	
	String x;
	
	ThreadOne(String a) {
		this.x = a;
	}
	
	public void run() {
		double b = Integer.parseInt(x);
		double sqrt = b * b; 
		String num = Double.toString(sqrt);
		Driver.array[0] = num;
		System.out.println("Thread One Starting: " + sqrt);
		
	}
}
