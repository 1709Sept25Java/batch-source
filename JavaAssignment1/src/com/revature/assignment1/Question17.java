package com.revature.assignment1;
import java.util.Scanner;

public class Question17 {

	public static void main(String[] args) {

		calculateSimpleInterest();
	}
	
	public static void calculateSimpleInterest() {
		Scanner sc = new Scanner(System.in);

        System.out.println("Enter principal: ");
        String principalInput = sc.nextLine();

        System.out.println("Enter rate: ");
        String rateInput = sc.nextLine();
        
        System.out.println("Enter time: ");
        String timeInput = sc.nextLine();
        
        Double principal = Double.parseDouble(principalInput);
        Double rate = Double.parseDouble(rateInput);
        Double time = Double.parseDouble(timeInput);
        
        Double simpleInterest = principal * rate * time;
        
        System.out.println("Calculated simple interest: " + simpleInterest );
	}

}
