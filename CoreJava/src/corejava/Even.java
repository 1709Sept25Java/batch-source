package corejava;

public class Even {
	
	public static boolean isEven(int num) {
		while(num > 0) {
			num = num - 2;  //keep subtracting 2 from num
			if(num == 0) { //if it gets to 0, then it means its even
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		int i = 11;
		if(isEven(i) == true) {
			System.out.println(i + " is an even number.");
		}
		else {
			System.out.println(i + " is not an even number.");
		}

	}

}
