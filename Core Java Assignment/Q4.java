package questions;

public class Q4 {

	private static void factorialFunct(long N) {
		//I used long because factorials easily produce very large numbers that overflow integers
		//but I didn't want to risk using double and potentially skewing my calculations
		//warn users when invalid number is entered into function
		if(N<=0) {
			System.out.println("Please enter a valid number to calculate its factorial.");
		}else if(N>0) {
			//execute factorial calculation
			for(long i=N-1; i>=1; i--) {
				long result = Math.multiplyExact(N, i);
				N=result;
				//print out final result
				if(i<2) {
					System.out.println(result);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		//create new Q4 object and test function
		Q4 testRun = new Q4();
		testRun.factorialFunct(6);
		testRun.factorialFunct(13);
		testRun.factorialFunct(20);
	}
}
