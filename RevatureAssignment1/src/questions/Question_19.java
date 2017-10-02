package questions;

import java.util.ArrayList;
/*
 Create an ArrayList and insert integers 1 through 10. 
 Display the ArrayList. 
 Add all the even numbers up and display the result. 
 Add all the odd numbers up and display the result. 
 Remove the prime numbers from the ArrayList and print out the remaining ArrayList.

 */
public class Question_19 {

	public static void main(String[] args) 
	{
		arraylist();
	}
	
	public static void arraylist() {
		int even=0,odd=0;int loop=0;
		ArrayList al= new ArrayList();
				for(int i=1; i<=10; i++) 
				{
					al.add(i);
				}
		System.out.println(al);
	
		for(int i=0; i<10; i++) 
		{
			if(Integer.parseInt(al.get(i).toString())%2==0)
			{
				even=Integer.parseInt(al.get(i).toString())+even;
			}
			if(Integer.parseInt(al.get(i).toString())%2!=0)
			{
				odd=Integer.parseInt(al.get(i).toString())+odd;
			}
		}
		for(int x=0; x<10; x++)
		{
			for(int y=1; y<=10; y++)
			{
			if(Integer.parseInt(al.get(x).toString())%(y)==0)
			{
				System.out.print(al.get(x)+" ");
			}
			}
		}
		for(int z=0; z<10; z++) 
		{
			for(int za=1; za<10; za++)
			{
				if(Integer.parseInt(al.get(z).toString())%za==0)
				{
					//System.out.print(al.get(z)+ " ");
				}
				if(Integer.parseInt(al.get(z).toString())%za!=0)
				{
					System.out.print(al.get(z)+ " ");
				}
			}
		}
		
		System.out.println("\nAdded even numbers: "+even+
				"\nAdded odd numbers: "+odd);
	}

}
