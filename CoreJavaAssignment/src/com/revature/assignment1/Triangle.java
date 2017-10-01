package com.revature.assignment1;

public class  Triangle {

	public static void main (String[] args) {
		for (int i=1; i<=4; i++)
		{
		    for (int j=0; j<i; j++)
		    {
		        System.out.print(((i+j)%2)+ " " );
		    }
		    System.out.println(" ");
		}
	}

}
