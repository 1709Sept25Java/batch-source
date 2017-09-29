package com.revature.threads;

public class ProducerConsumer {
	public static void main (String[] args) {
		System.out.println(Thread.currentThread().getName());
		Basket b = new Basket();
		Runnable producerJob = new Producer(b);
		Runnable consumerJob = new Consumer(b);
		Thread producerWorker = new Thread(producerJob,"PRODUCER");
		Thread consumerWorker = new Thread(consumerJob,"CONSUMER");
		producerWorker.start();
		consumerWorker.start();
		
		//Quiz on monday
		//Next coding challenge
		/*
		 * Quiz on monday at 10
		 * 1-on-1 interview 
		 * hw due at 9 am
		 * coding challenge
		 */
		
	}
}

class Basket {
	private int contents;
	private boolean available = false;
	
	public synchronized int get() {
		
		while(!available) {
			try {
				System.out.println("\t\t\t"+Thread.currentThread().getName()+" is waiting");
				wait();
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		available = false;
		notifyAll();
		return contents;
	}
	
	public synchronized void put(int value) {
		while(!available) {
			try {
				System.out.println("\t\t\t"+Thread.currentThread().getName()+" is waiting");
				wait();
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		contents = value;
		available = true;
		notifyAll();
	}
}

class Producer implements Runnable {
	private Basket basket;
	
	public Producer(Basket b) {
		this.basket = b;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i=0; i<10; i++) {
			basket.put(i);
			System.out.println(Thread.currentThread().getName()+" put: "+i);
			try {
				Thread.sleep((int)(Math.random()*100));
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class Consumer implements Runnable {
	private Basket basket;
	
	public Consumer(Basket b) {
		this.basket = b;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i=0; i<10; i++) {
			int value = 0;
			value = basket.get();
			System.out.println(Thread.currentThread().getName()+" got: "+value);
		}
	}
}
