import java.util.Scanner;

//question 17
public class SimpleInterest {
	double principle;
	double rate;
	double time;
	public SimpleInterest() {
		
	}
	public SimpleInterest(double principle, double rate, double time) {
		this.principle=principle;
		this.rate=rate;
		this.time=time;
	}
	public void setPrinciple(double principle) {
		principle = principle;
	}
	public void setRate(double rate) {
		rate=rate;
	}
	public void setTime(double time) {
		time=time;
	}
	public double getPrinciple() {
		return principle;
	}
	public double getRate() {
		return rate;
	}
	public double getTime() {
		return time;
	}
	public static void SimpleInterestCalculation() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter principle amount: $");
		double principle = sc.nextDouble();
		System.out.print("Enter amount of rate: ");
		double rate = sc.nextDouble();
		
		System.out.print("Enter amount of time: ");
		double time = sc.nextDouble();
		
		double interest = principle * rate * time;
		System.out.println("Your interest is: $" + interest);
		
	}
	public static void main(String[] args) {
		SimpleInterestCalculation();
		
	}

}
