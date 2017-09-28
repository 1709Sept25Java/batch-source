package corejava;

public class MinWithTernary {

	public static int min(int a, int b) {
		int min = (a < b)? a : b; // if a < b, then min = a, else it = b
		return min;
	}
	public static void main(String[] args) {
		int a = 5;
		int b = 3;
		System.out.println("The minimum value is " + min(a,b) + ".");

	}

}
