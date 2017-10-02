package questions;

import question11package.Question11_Dummy;

public class Question_11 {
/**
 Write a program that would access two float-variables from a class that exists in another package. 
 Note, you will need to create two packages to demonstrate the solution.
 */
	public static void main(String[] args) 
	{
		//grabbed from dummypackage an instance of the class
		question11package.Question11_Dummy q1= new question11package.Question11_Dummy();
		System.out.println(q1.dummy1);
		System.out.println(q1.dummy2);
		//Yes I reversed the numbers
	}

}
