package com.revature.java;


public class ThreadDeadlock {
	
	public static Object Lock1 = new Object();
	public static Object Lock2 = new Object();

	
 }
 
 private static class ThreadDemo1 extends Thread {
	 ThreadDemo1 T1 = new ThreadDemo1();
	    ThreadDemo2 T2 = new ThreadDemo2();
	    T1.start();
	    T2.start();
 }
    public void run() {
       synchronized (Lock1) {
          System.out.println("Thread 1: Holding lock 1...");
          
          try {
             Thread.sleep(10);
          }catch (InterruptedException e) {}
          System.out.println("Thread 1: Waiting for lock 2...");
          
          synchronized (Lock2) {
             System.out.println("Thread 1: Holding lock 1 & 2...");
          }
       }
    }
 }
 private static class ThreadDemo2 extends Thread {
    public void run() {
       synchronized (Lock1) {
          System.out.println("Thread 2: Holding lock 1...");
         
          try {
             Thread.sleep(10);
          }catch (InterruptedException e) {}
          System.out.println("Thread 2: Waiting for lock 2...");
          
          synchronized (Lock2) {
             System.out.println("Thread 2: Holding lock 1 & 2...");
          }
       }
    }
	

}
