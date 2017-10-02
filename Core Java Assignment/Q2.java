package questions;

import java.util.Arrays;

public class Q2 {
	
	public Q2() {
		super();
	}
	
	//create an empty array in which to hold the first 25 numbers of the Fibonacci sequence
	static int[] fibArr = new int[25];
		
	private void fibFunct(int arr[]) {
			
		for(int n=0; n<arr.length; n++) {
			//establish 0, 1, 1 as the first 3 numbers in the sequence and empty array
			if(n<=0) {
				arr[n] = 0;
				System.out.println(arr[n]);
			} else if(n<=2) {
				arr[n] = 1;
				System.out.println(arr[n]);
			//define function for execution of Fibonacci formula
			} else if(n>2) {
				arr[n] = arr[n-1] + arr[n-2];
				System.out.println(arr[n]);
			} else {
			}
		}
		//print result	
		System.out.println("The first 25 numbers of the Fibonacci sequence are "+Arrays.toString(arr));
	} 
	

	public static void main(String[] args) {
		//run function on new Q2 object
		Q2 testRun = new Q2();
		testRun.fibFunct(fibArr);
	}

}
