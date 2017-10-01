package com.revature;
import java.util.Scanner;

public class Q19_IntArray {
	//method to create an arraylist of 1 to 10. you enter in a number and then enter in the 
	//the sequence of the two numbers and it then calculates the sum of even and odd for the set.
    public static void main(String[] args) {

        int n, sumE = 0, sumO = 0;
        Scanner s = new Scanner(System.in);
        System.out.print("Enter the number of elements in array:");

        n = s.nextInt();
        int[] a = new int[n];
        System.out.println("Enter the elements of the array:");

        for(int i = 0; i < n; i++){
            a[i] = s.nextInt();
        		}
        for(int i = 0; i < n; i++){

        if(a[i] % 2 == 0){
        		sumE = sumE + a[i];
        		}
        else{
        		sumO = sumO + a[i];
            }
        }

        System.out.println("Sum of Even Numbers:"+sumE);
        System.out.println("Sum of Odd Numbers:"+sumO);
    }
}