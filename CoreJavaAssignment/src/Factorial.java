//Question 4
public class Factorial {
	public static int factorial(int factorial) {
		int n = 1;
		for (int i = 1; i <= factorial; i++) {
			n = n * i;
		}
		return n;
	}

	public static void main(String[] arg) {
		int factorial = 5;
		int n = factorial(factorial);
		System.out.println(n);
	}
}
