package com.revature.threads.array;

public class ThreadTwo extends Thread{
	String[] array;
	
	ThreadTwo(String[] array) {
		this.array = array;
	}

	public void run() {
		System.out.println("Thread Two Starting: " + array[2]);
	}
}
