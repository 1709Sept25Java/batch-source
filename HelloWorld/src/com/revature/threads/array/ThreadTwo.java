package com.revature.threads.array;

public class ThreadTwo extends Thread {
	
	String y;
	ThreadTwo(String y) {
		this.y = y;
	}
	
	public void run() {
		System.out.println("Thread Two Starting: " + y);
	}
}
