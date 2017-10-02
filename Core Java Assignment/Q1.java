package questions;

import java.util.Arrays;

public class Q1 {
	
	public static void main(String[] args) {
		Q1 testRun = new Q1();
		testRun.bubbleSort(arr1);
		//System.out.println(arr1);
	}
	
	public static int[] arr1 = {1,0,5,6,3,2,3,7,9,8,4};
	
	private void bubbleSort(int arr[]) {
		
		int n = arr.length;
		int temp = 5;
		int i = 0;
		
		//for(int i=0;i<=n-1;i++){
			for(int j=i+1; j<n; j++) {
				if(arr[i] > arr[j]) {
					//change it to reference the value of the array element, not the loop variable 
					j = temp;
					i = j;
					temp = i;
					System.out.println(Arrays.toString(arr));
					//break;
				} else if(i==n-1) {
					//return;
				} 
				
			}
		}
		
	}

	
//}
