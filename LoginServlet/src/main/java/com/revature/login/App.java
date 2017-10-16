package com.revature.login;

public class App {
	
	public static void main(String[] args){
		
		System.out.println("login page");
		
		LoginClass logger = new LoginClass();
		logger.someMethod();
		
		try{
			exceptionThrowingGarbage();
		} catch(RuntimeException r){
			logger.giveFatal(r);
		}
		
	}
	
	public static void exceptionThrowingGarbage(){
		int i = 5/0;
	}

}

