package questions;
import java.util.Scanner;

/**Write a program that calculates the simple interest on the principal, 
rate of interest and number of years provided by the user. 
Enter principal, rate and time through the console using the Scanner class.
Interest = Principal* Rate* Time
**/

public class Question_17 {

	public static void main(String[] args) {
		Interest();

	}
	public static void Interest()
	{
		Scanner scan= new Scanner(System.in);
		System.out.println("Type in the Principal");
		Double principal =scan.nextDouble();
		System.out.println("Type in the Rate");
		Double rate= scan.nextDouble();
		System.out.println("Type in the Time");
		Double time= scan.nextDouble();
		
		double interest= principal*rate*time;
		System.out.println(interest);
	}

}
