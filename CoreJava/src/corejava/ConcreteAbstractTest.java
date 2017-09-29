package corejava;

public class ConcreteAbstractTest {

	public static void main(String[] args) {
		String str = "Apple"; //string to check for uppercase and to change to uppercase
		String num = "10"; //string to turn into int
		Concrete c = new Concrete(); //create a concrete object to call its methods
		System.out.println("There are uppercases in the string " + str + ": " + c.isThereUpper(str));
		System.out.println(c.upper(str));
		System.out.println(c.strToInt(num));
		
		

	}

}
