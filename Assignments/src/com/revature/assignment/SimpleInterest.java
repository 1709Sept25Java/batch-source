package com.revature.assignment;
import java.util.Scanner ;


public class SimpleInterest {
	public static float simpleInterest(float principle, float rate, float time){
        float interest = (principle*rate*time)/100;
        return interest;
    }

	public static void main(String[] args) {
		
		//creating scanner to accept principle, rate and time input form user
        Scanner input = new Scanner(System.in);
        
        System.out.println("Please enter principle amount :");
        float amount = input.nextFloat();
      
        System.out.println("Enter time in years : ");
        float time = input.nextFloat();
      
        System.out.println("Enter rate annually : ");
        float rate = input.nextFloat();
      
        float interest = simpleInterest(amount, rate, time);
      
        System.out.println("Simple interested calculate by program is  : $" + interest);
    }
  
    
}

	


