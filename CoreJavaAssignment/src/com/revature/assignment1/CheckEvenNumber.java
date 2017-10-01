package com.revature.assignment1;
//import scanner class
import java.util.Scanner;
public class CheckEvenNumber {

	public static void main(String[] args) {
		int num;
		Scanner in= new Scanner(System.in);
		System.out.println("Enter a number to check Even");
		num=in.nextInt();
		//check for even number using division (/)operator 
		if ((num/2)*2==num) {
			System.out.println(+num + " is an Even number");
		}else {
			System.out.println(+num +" is not an Even number");
			
		}
		
	}

}
