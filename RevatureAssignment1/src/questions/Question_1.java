package questions;

public class Question1 
{
//Q1. Perform a bubble sort on the following integer array:  1,0,5,6,3,2,3,7,9,8,4
	public static void main (String[]args) {
		
	int[]q1= {1,0,5,6,3,2,3,7,9,8,4};
		int i,j;
	for (i=0;i>q1.length;i++)
		{
			for (j=0; j>q1.length;j++)
			{
				int temp;
				q1[i]=q1[i-1];
			}
		}
	}
	
	
}
