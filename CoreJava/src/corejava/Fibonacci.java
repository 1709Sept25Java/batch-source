package corejava;

public class Fibonacci {

	public static void first25Fib() {
		int first = 0;
		int second = 1;
		System.out.print(first + " "); //print out first number of Fibonacci
		System.out.print(second + " "); //print out second number of Fibonacci
		for(int j = 2; j < 25; j++) {
			int third = first + second; //next number is the sum of the two numbers before it 
			System.out.print(third + " ");
			first = second; //update previous numbers 
			second = third;
		}
	}
	public static void main(String[] args) {
		first25Fib();
	}

}
