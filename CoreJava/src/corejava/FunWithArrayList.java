package corejava;

import java.util.*;

public class FunWithArrayList {

	public static void addEven(ArrayList<Integer> al) { //adds all the even numbers in ArrayList 
		int even = 0;
		for(int i: al) {
			if(Even.isEven(i)) { //checks to see if number is Even
				even += i;
			}
		}
		System.out.println("The sum of all the even numbers is " + even + ".");
	}
	
	public static void addOdd(ArrayList<Integer> al) { //adds all the odd numbers in ArrayList
		int odd = 0;
		for(int i: al) {
			if(!Even.isEven(i)) { //check to see if number is NOT Even
				odd += i;
			}
		}
		System.out.println("The sum of all the odd numbers is " + odd + ".");
	}
	
	public static void removePrime(ArrayList<Integer> al) {
		Iterator<Integer> it = al.iterator(); //iterator to traverse ArrayList 
		while(it.hasNext()) { //breaks if iterator does not have next
			int i = it.next();
			if(Prime.isPrime(i)) { //checks to see if number is prime
				it.remove(); //removes number if it is prime 
			}
		}
		System.out.println(al.toString());
	}
	
	public static void main(String[] args) {
		ArrayList<Integer> al = new ArrayList<Integer>();
		for(int i = 1; i <= 10; i++) { //fill ArrayList with numbers 1-10
			al.add(i);
		}
		
		//call and print out results
		System.out.println(al.toString());
		addEven(al);
		addOdd(al);
		removePrime(al);
	}

}
