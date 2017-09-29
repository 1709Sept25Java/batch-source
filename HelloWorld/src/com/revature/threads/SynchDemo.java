package com.revature.threads;

public class SynchDemo {

	public static void main(String[] args) {
		//create and start two threads, which call an increment() method 500 times

		Count c = new Count();
		Runnable job = new TestRunnable(c);
		
		Thread t1 = new Thread(job);
		Thread t2 = new Thread(job);
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Count: " + c.count);
		
//		int i = 1;
//		int j = i++; //after execution
//		++i; //before execution 
//		System.out.println(i);
//		System.out.println(j);
//		int k = j++;
//		System.out.println(k);
//		System.out.println(j);
		
		
	}
}

class Count {
	int count; 
	public void increment() {
		count++;
	}
}

class TestRunnable implements Runnable {
	Count c;
	
	public TestRunnable(Count c) {
		this.c = c;
	}
	
	
	
	@Override 
	public void run() {
		for (int i=0; i<5000; i++) {
			c.increment();
		}
	}
}
