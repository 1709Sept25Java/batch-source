package com.revature.threads;

public class DeadlockExample {
	
	//declare and assign variables that will be used as resources
	final static String resource1 = "apple";
	final static String resource2 = "banana";
	
	public static void main(String[] args) {
		ThreadDemo1 t1 = new ThreadDemo1();
		ThreadDemo2 t2 = new ThreadDemo2();
		
		t1.start();
		t2.start();
	}
		//tries to lock resource1 then 2
		private static class ThreadDemo1 extends Thread {
			public void run() {
				synchronized(resource1) {
					System.out.println("Thread 1: Holding resource 1");
					
					try {
						Thread.sleep(10);
					}
					catch(Exception e) {
						System.out.println("Thread 1: Waiting for resource 2");
					}
					
					synchronized (resource2) {
						System.out.println("Thread 1: Holding resource 2");
					}
				}
			}
		}
		
		//t2 tries to lock resource2 then resource1
		private static class ThreadDemo2 extends Thread{
			public void run() {
				synchronized (resource2) {
					System.out.println("Thread 2: Holding resource 2");
					
					try {
						Thread.sleep(10);
					}
					catch(Exception e) {
						System.out.println("Thread 2: Waiting for resource 1 ");
					}
					
					synchronized (resource1) {
						System.out.println("Thread 2: Holding resource 1");
					}
				}
			}
		}

}
