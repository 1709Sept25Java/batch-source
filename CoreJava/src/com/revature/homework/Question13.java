package com.revature.homework;

public class Question13 {

	public static void main(String[] args) {
		
		int count=0;
		for(int i=0; i<4; i++) {
			for(int j=0;j<=i; j++) {
				System.out.print(count%2);
				count++;
			}
			System.out.println();
		}
	}
	
}
