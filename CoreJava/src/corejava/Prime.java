package corejava;

import java.util.ArrayList;

public class Prime {
	
	public static boolean isPrime(int num) {
		if(num == 1) { //1 is alway a prime number
			return false;
		}
		else if(num == 2) { //2 is a prime number as well 
			return true;
		}
		else {
			double n = (double)num/2; //to be used to determine possible factors
			for(int i = 2; i <= n; i++) {
				if(num%i == 0) { //is not prime if modulus results in 0, means that i is a factor of the number
					return false;
				}
			}
			return true;
		}
	}

	public static void main(String[] args) {
		ArrayList<Integer> al = new ArrayList<Integer>();
		for(int i = 1; i <= 100; i++) {
			al.add(i); //traverse through numbers 1-100 and add to ArrayList 
		}
		System.out.print("Prime Numbers from 1-100: ");
		for(int num: al) {
			if(isPrime(num) == true) {
				System.out.print(num + " ");
			}
		}
	}

}
