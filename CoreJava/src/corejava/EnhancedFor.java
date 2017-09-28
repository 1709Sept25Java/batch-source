package corejava;

import corejava.Even;

public class EnhancedFor {

	public static void main(String[] args) {
		
		int[] ar = new int[100];
		int index = 0;
		for(int i = 1; i <= 100; i++) { //fill array with numbers 1-100
			ar[index] = i;
			index++;
		}
		
		for(int j: ar) {
			if(Even.isEven(j) == true) { //use isEven method from Even class 
				System.out.print(j + " "); //prints out even numbers from the array 
			}
		}
	}

}
