package com.revature.threads;

public class SynchDemo {

	public static void main(String[] args) {
		
		// create and start two threads, which call in increment() methods 500 times
		
		/*int i = 1;
		int j = ++i; //  j = 2
		int k = j++; //  k = 2 J = 3
		 */
		Count c = new Count();
		Runnable job = new TestRunnable(c);
		Thread t1 = new Thread(job);
		Thread t2 = new Thread(job);
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();;
			
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Count: " +c.count);
	}
	

}

class Count {
	int count;
	public synchronized void increment () { //synchronized keyword is important for threads to be synchronized
		count++;							//or else each output is different 
	}
}
class TestRunnable implements Runnable{

	Count c;
	public TestRunnable(Count c) {
		this.c=c;
	}
	@Override
	public void run() {
		for(int i = 0; i< 5000; i++) {
			c.increment();
			System.out.println(i);
		}
		
	}
	
}
