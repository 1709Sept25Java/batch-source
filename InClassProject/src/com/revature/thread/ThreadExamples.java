package com.revature.thread;

public class ThreadExamples {
	public static void main(String[] args) {
		 	
		 	String[] stringArray = {"6", "hello", "world"};
		 	
		 	Thread Thread1 = new Thread() {
		 		public void run() {
		 			int stringInt = Integer.parseInt(stringArray[0]);
		 			System.out.println(stringInt*stringInt);
		}
		 	};
		 
		 	Thread Thread2 = new Thread() {
		 	public void run() {
		 			System.out.println(stringArray[1]);	
		 	}
			};
		 	
		 Thread Thread3 = new Thread() {
			public void run() {
					String str3 = stringArray[2];
					char[] charArray = str3.toCharArray();
					for(int i = 0; i<charArray.length; i++) {
						if (i%2 == 0) {
		 					charArray[i] = Character.toUpperCase(charArray[i]);
		 				}
		 		}
		 			str3 = "";
		 		for(int i = 0; i<charArray.length; i++) {
		 
			 			str3 = str3 + charArray[i];
		 		}
		 		System.out.println(str3);
		 	
		 		}
		 	};
		 	
		 	Thread1.start();
		 	try {Thread1.join();} catch (Exception e) {}
		 	Thread2.start();
		 try {Thread2.join();} catch (Exception e) {}
		 	Thread3.start();
		 
		 
		 	
		 }
		 }


