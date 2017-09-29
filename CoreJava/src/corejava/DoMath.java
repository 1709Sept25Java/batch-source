package corejava;

public class DoMath implements MathOperators { //implements methods from MathOperator interface 

	//private variables of DoMath Class
	private double a; 
	private double b;
	
	//constructor for DoMath Class
	public DoMath() {
		super();
	}
	
	//constructor with private variables as arguments 
	public DoMath(double a, double b) {
		this.a = a;
		this.b = b;
	}
	
	@Override
	public void addition(double a, double b) {
		System.out.println("The sum of " + this.a + " and " + this.b + " is " + (this.a + this.b) + ".");
		
	}

	@Override
	public void subtraction(double a, double b) {
		System.out.println("The difference between " + this.a + " and " + this.b + " is " + (this.a - this.b) + ".");
		
	}

	@Override
	public void multiplication(double a, double b) {
		System.out.println("The product of " + this.a + " and " + this.b + " is " + (this.a * this.b) + ".");
		
	}

	@Override
	public void division(double a, double b) {
		System.out.println("The quotient of " + this.a + " and " + this.b + " is " + (this.a / this.b) + ".");
		
	}	


}
