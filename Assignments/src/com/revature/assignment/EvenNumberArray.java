package com.revature.assignment;

public class EvenNumberArray {

	public static void main(String[] args) {
		
		int array[] = new int [100];
		
		int n =  array.length ;
		
		
		for ( int i = 0 ; i < array.length  ; i++){
			array[i] = i + 1   ;
		}
		
		System.out.println(" Event Number are " );
				
		for( int x = 1; x <= array.length; x++)	{

			 if ( x%2 == 0);
		
			 
			System.out.println(x);
		}
			 
		}
	}
			 
			
	
	