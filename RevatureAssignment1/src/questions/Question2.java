package questions;

public class Question2 {
	// Write a program to display the first 25 Fibonacci numbers beginning at 0.

	public static void main (String[]args) {
		for(int i=0; i<=25; i++) {
		System.out.println("Fibonacci" + " " + i + ": " + q2(i) + " ");
		}
		
	}
		public static int q2(int j) {
		if (j<=3)		
			return j;
		else
			return q2(j-1)+q2(j-2);
		}

}
