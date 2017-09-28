package corejava;

public class Factorial {
	
	public static int nFactorial(int n) {
		int product = 1;
		for(int i = n; i > 0; i--) { //traverse through all numbers between 1 and the argument 
			product *= i; //multiply it to the variable product 
		}
		return product;
	}

	public static void main(String[] args) {
		int fact = nFactorial(5);
		System.out.println(fact);

	}

}
