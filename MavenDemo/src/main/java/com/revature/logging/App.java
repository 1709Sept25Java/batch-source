package com.revature.logging;

public class App {

	public static void main(String[] args) {
		
		System.out.println("Hello World");
		
		LoggingClass logger = new LoggingClass();
		logger.someMethod(); //default behavior with no configuration we get a warning level error message doesn't break our program but we havent specified where to log
		
		try {
			exceptionThrowingGarbage();
		} catch(RuntimeException r) { //checked exception 
			logger.giveFatal(r);
		}
		
		
	} 
	
	public static void exceptionThrowingGarbage() {
		int i = 5/0;
	}
	
} 
