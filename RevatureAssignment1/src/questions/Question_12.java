package questions;

/**
Q12. Write a program to store numbers from 1 to 100 in an array. 
Print out all the even numbers from the array. 
Use the enhanced FOR loop for printing out the numbers.
 */
public class Question_12 {
	 public static void main (String []args)
	 {
		 evenArray();
	 }
	 
	 public static void evenArray() {
		 int []arr = new int[101]; 
		 for (int i=1; i<=100; i++)
		 {
			 arr[i]=i;
		 }
		 
		 for (int x:arr) 
		 {
			 if(x%2==0) 
			 {
			 System.out.println(arr[x]);
			 }
		 }
	 }
}
