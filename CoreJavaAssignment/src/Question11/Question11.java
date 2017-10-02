package Question11;

public class Question11 {

	protected static float r = (float) 3.6896;
	protected static float x = (float) 3.14159265359;
	protected static float sum = 0;
	public static void Add() {
		sum = x+r;
		System.out.println("Adding: " + x + " + "+ r + " = "+ sum);
		
	}
	public static void main(String[] args) {
		Add();

	}

}
