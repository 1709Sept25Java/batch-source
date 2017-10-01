package com.revature.assignment;
import java.util.ArrayList;

public class ArrayNumbers {
	
	private static boolean isPrime(int i)
	{
		int count = 0; // counter 0f even number 
		
		for(int x = 1; x <= i; x++)
			if( i % x == 0)
				count++;
			
		if( i <= 3 ) // prime number 
			return true;
		else if( count > 2)
			return false;
		else
			return true;
	}

	public static void main(String[] args) {
		
ArrayList<Integer> array = new ArrayList<Integer>();
		
		for(int i = 1; i <= 10; i++)
			array.add(i);
		
		System.out.println("ArrayList: " + array);
		
		int even = 0;
		int odd = 0;
		
	
		// sum even,  odd and  remove primes
		for(int y = 0; y < array.size(); y++ )
		{
			Integer num = array.get(y);
			
			if( num % 2 == 0 )
				even = even + num;
			if( num % 2 == 1  )
				odd = odd + num;
			
			
			if( isPrime(num) )
			{		
				array.remove(y);
				y--;              // prime number 
			}
	
		}
	
		System.out.println(" sum of the even numbers: " + even);
		System.out.println(" sum of the odd numbers: " + odd);
		System.out.println( "ArrayList (without prime numbers ): " + array );
		
		
		

	}

}
