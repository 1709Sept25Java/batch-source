package questions;

// Reverse a string without using a temporary variable.  
	// Do NOT use reverse() in the StringBuffer or the StringBuilder APIs.

public class Question_3 {
	
	public static void main(String[] args) {
		int[] arr1 = {1,0,5,6,3,2,3,7,9,8,4};
		System.out.println(Question_3.Reverse(arr1));
}

public static String Reverse(int[] arr) {

	for (int i=0; i<arr.length/2; i++) {
		int temp= arr[i];
		arr[i]=arr[arr.length-i-1];
		arr[arr.length-i-1]=temp;
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
