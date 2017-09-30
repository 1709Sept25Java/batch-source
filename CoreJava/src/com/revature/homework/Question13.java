package com.revature.homework;

public class Question13 {

	public static void main(String[] args) {
		
		int count=0;
		//nested loop to print in triangular format
		for(int i=0; i<4; i++) {
			for(int j=0;j<=i; j++) {
				//switch between printing 0 and 1
				System.out.print(count%2); 
				count++;
			}
			System.out.println(); //end the line
		}
	}
	
}
