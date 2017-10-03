package com.revature.java;

class MyClass extends Thread{
  

	public void run( ) {
	for (int i = 0; i < 10; i++) {
		System.out.println(" Valu" +i);
	}
	}
}
public class Threads{
	
	public static void main(String[] args) {
		MyClass myclass = new MyClass();
		myclass.start();
		MyClass myclass1 = new MyClass();
		myclass1.start();
		MyClass myClass2 = new MyClass();
		myClass2.start();
	}

}
