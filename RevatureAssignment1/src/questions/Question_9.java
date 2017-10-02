package questions;
import java.util.ArrayList;

/**
Create an ArrayList which stores numbers from 1 to 100 and 
prints out all the prime numbers to the console.
 */
public class Question_9 {

	public static void main(String[] args) 
	{
		primeArray();
	}
	public static void primeArray()
	{
		ArrayList al= new ArrayList();
		ArrayList al2= new ArrayList();

	       for(int addnum=1; addnum<=100; addnum++) {
	    	   al.add(addnum);	  
	       }
	        System.out.println("Original: "+al);
	        
	       for (int i = 1; i <= al.size()-1; i++)         
	       { 
	          int loop=0; 	  
	          for(int x =i; x>=1; x--)
				{
					if(i%x==0)
				    {
					//checks if number is prime in list
					  loop++;
				    }
				}
				    if (loop==2)
				    {
				    	al2.add(i);
				    }	
		   }
	       System.out.println(al2);
	       
	}

}
