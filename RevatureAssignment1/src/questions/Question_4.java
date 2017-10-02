package questions;

public class Question4 {

	//write a program that computes N factorial

	public static void main (String[]args) {
		int num=1;
		int loop=10;
		for(int i=1; i<=loop; i++) {
			num=num*i;
			System.out.println("n!" + " " + i + ": " + num);
		}
	}

}
