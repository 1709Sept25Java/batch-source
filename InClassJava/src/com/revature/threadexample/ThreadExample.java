package com.revature.threadexample;

public class ThreadExample {

	
public static void main(String[] args) {
	
	String[] stringArray = {"6", "hello", "world"};
	
	Thread Thread1 = new Thread() {
		public void run() {
			int stringInt = Integer.parseInt(stringArray[0]);
			stringInt = stringInt*stringInt;
			stringArray[0] = Integer.toString(stringInt);
			System.out.println(stringInt);
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
			stringArray[2] = str3;
			System.out.println(stringArray[2]);
			
		}
	};
	
	Thread1.start();
	try {Thread1.join();} catch (Exception e) {}
	Thread2.start();
	try {Thread2.join();} catch (Exception e) {}
	Thread3.start();
	
	
}

}
