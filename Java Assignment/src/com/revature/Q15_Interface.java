package com.revature;
import java.util.Scanner;
public class Q15_Interface {
	//method to calculate what operation the user wants to do
	public static void main(String[] args) {

        Scanner kb = new Scanner(System.in);

        System.out.println("Simple Calculator");

        System.out.println("\nHere are your options:");
        System.out.println("\n1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Division");
        System.out.println("4. Multiplication");

        System.out.print("\nWhat would you like to do?: ");
        int choice = kb.nextInt();
        System.out.println();


        if (choice == 1){
            addition();
        }
        else if (choice == 2){
            subtraction();
        }
        else if (choice == 3){
            division();
        }
        else if (choice == 4){
            multiplication();
        }

        System.out.println();
        kb.close();
    }

    public static void addition(){

        int nOne, nTwo;
        Scanner kb = new Scanner(System.in);

        System.out.println("Addition");

        System.out.print("\nFirst Number: ");
        nOne = kb.nextInt();

        System.out.print("\nSecond Number: ");
        nTwo = kb.nextInt();

        kb.close();
        System.out.println("\nSum: " + nOne + " + " + nTwo + " = " + (nOne + nTwo));
    }

    public static void subtraction(){
        int nOne, nTwo;
        Scanner kb = new Scanner(System.in);

        System.out.println("Subtraction");

        System.out.print("\nFirst Number: ");
        nOne = kb.nextInt();

        System.out.print("\nSecond Number: ");
        nTwo = kb.nextInt();

        kb.close();
        System.out.println("\nSum: " + nOne + " - " + nTwo + " = " + (nOne - nTwo));
    }

    public static void division(){
        int nOne, nTwo;
        Scanner kb = new Scanner(System.in);

        System.out.println("Division");

        System.out.print("\nFirst Number: ");
        nOne = kb.nextInt();

        System.out.print("\nSecond Number: ");
        nTwo = kb.nextInt();

        kb.close();
        System.out.println("\nSum: " + nOne + " / " + nTwo + " = " + (nOne / nTwo));
    }

    public static void multiplication(){
        int nOne, nTwo;
        Scanner kb = new Scanner(System.in);

        System.out.println("Multiplication");

        System.out.print("\nFirst Number: ");
        nOne = kb.nextInt();

        System.out.print("\nSecond Number: ");
        nTwo = kb.nextInt();

        kb.close();
        System.out.println("\nSum: " + nOne + " x " + nTwo + " = " + (nOne * nTwo));
    }
	
}
