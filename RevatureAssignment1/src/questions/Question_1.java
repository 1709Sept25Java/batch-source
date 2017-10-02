package questions;
//Q1. Perform a bubble sort on the following integer array:  1,0,5,6,3,2,3,7,9,8,4

public class Question_1 {
		
		public static void main(String[] args) {
			int[] arr1 = {1,0,5,6,3,2,3,7,9,8,4};
			System.out.println(Question_1.bubbleSort(arr1));
	}

	public static String bubbleSort(int[] arr) {

		for (int j=0; j<arr.length; j++) {
			for (int i=0; i<(arr.length-1); i++) {
				if (arr[i]>arr[i+1]) {
					int temp = arr[i];
					arr[i] = arr[i+1];
					arr[i+1] = temp;
				}
			}
		}
		return printArray(arr);	
	}
	
	public static String printArray(int[] arr) {
		String str = "";
		for (int i=0; i<arr.length; i++) {
			str = str +" "+ arr[i];
		}
		return str;
	}
}
