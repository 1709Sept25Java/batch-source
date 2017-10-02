//Question 2
public class Fibonacci {
	public static int a = 25;

	public static void main(String[] args) {
		int[] fib = new int[25];
		fib[0]= 0;
		fib[1] = 1;
		fibonacci(fib);
	}

	public static void fibonacci(int[] fib) {
		for (int i = 2; i < a; i++) {
			fib[i] = fib[i - 1] + fib[i - 2];

		}
		for (int i = 0; i < a; i++) {
			System.out.print(fib[i] + " ");

		}

	}

}
