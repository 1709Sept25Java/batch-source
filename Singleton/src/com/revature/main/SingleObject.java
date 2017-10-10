package com.revature.main;

public class SingleObject {
	private static SingleObject obj = new SingleObject();
	
	private SingleObject() {
		super();
	}
	
	public static SingleObject getInstance() {
		return obj;
	}
	
	
	
	public void counting() {
		for (int i=1; i<10; i++) {
			System.out.println(i);
		}
	}

}
