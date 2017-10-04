package com.revature.threads;

/*
 * Function that purposely causes a deadlock. Two threads try to access the same
 * Bank account amount and lock each other from the resource.
 * */

public class Deadlock {

	public static void main(String[] args) {
		
		Bank b = new Bank();
		Runnable job = new Person(b);
		
		Thread t1 = new Thread(job);
		Thread t2 = new Thread(job);
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
}

class Bank{
	
	private Double balance;
	private Boolean available;
	
	public Bank() {
		super();
		balance=1000.00;
		available =true;
	}
	
	public void deposit(Double amount) {
		if(available) {
			available = false;
			balance += amount;
			System.out.println("New balance is: "+balance);
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			available = true;
		} else {
			System.out.println("Cann't access!");
		}
		
	}
	
	public void withdraw(Double amount) {
		
		if(available) {
			available = false;
			balance-=amount;
			System.out.println("New balance is: "+balance);
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			available = true;
		} else {
			System.out.println("Cann't access!");
		}
	}
}

class Person implements Runnable {
	
	private Bank b;
	
	public Person(Bank b) {
		this.b=b;
	}

	@Override
	public void run() {
		
		for(int i=0; i<50; i++) {
			b.withdraw(10.0);
			b.deposit(10.0);
		}
		
	}
	
	
	
}

