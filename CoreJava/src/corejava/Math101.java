package corejava;

public class Math101 extends DoMath{ //inherits the method from 

	public static void main(String[] args) {
		double a = 4;
		double b = 5;
		DoMath d = new DoMath(a, b); //create a DoMath object with fields a and b
		
		//call DoMath methods 
		d.addition(a, b); 
		d.subtraction(a, b);
		d.multiplication(a, b);
		d.division(a, b);

	}

}
