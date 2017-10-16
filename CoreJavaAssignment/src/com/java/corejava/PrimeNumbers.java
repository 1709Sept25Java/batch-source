package com.java.corejava;

public class PrimeNumbers {

	public static void main(String[] args) {

        System.out.println("Prime numbers between 1 and 100");

        
        for(int i = 2; i < 100; i++){ //loop through the numbers one by one

                boolean isPrime = true;
                
                for(int j = 2; j < i ; j++){   //check to see if the number is prime

                        if(i % j == 0){ // it is not prime if this condition is met 
                                isPrime = false;
                                break; //break and execute the sysout 
                        }
                }
                
                if(isPrime)
                        System.out.print(i + " "); // print the number
        }
	}
}

// should print 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97
// prime numbers are divisible only by 1 and its self 