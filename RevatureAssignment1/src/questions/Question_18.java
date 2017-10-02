package questions;
import java.util.*;
/*
 Write a program having a concrete subclass that inherits three abstract methods from a superclass.  
 Provide the following three implementations in the subclass corresponding to 
 the abstract methods in the superclass:
 
1. 	Check for uppercase characters in a string, and return ‘true’ or ‘false’ depending if any are found.
2. 	Convert all of the lower case characters to uppercase in the input string, and return the result.
3. 	Convert the input string to integer and add 10, output the result to the console.
Create an appropriate class having a main method to test the above setup.

 */
abstract class AbstractTest{
	
	public abstract Boolean upper(Boolean uppercase);
	public abstract String changeLower(String low);
	public abstract int addLower(int stringlow, int num);
	}

public class Question_18 extends AbstractTest {

	public static void main(String[] args) 
	{
		uppercase();
	}
	
	
	public static void uppercase() {
		Scanner scan= new Scanner(System.in);
		System.out.println("Type in a word, and it will check if it is uppercase and convert all to uppercase");
		String upp=scan.next();
		
		Question_18 at= new Question_18();
		//Boolean upper
		for (int i=0; i<upp.length(); i++) 
		{
			if(at.upper(Character.isUpperCase(upp.charAt(i)))) {
				System.out.println("true");
				//lowercase
				System.out.println(at.changeLower(upp));
			}
			else {
				System.out.print("false "+"\n");
			}
		}
		
		//add number +10	
			
		System.out.println("Type in an integer");
		String a= scan.next();
		try{int b=Integer.parseInt(a);
		System.out.println(at.addLower(b, 10));
		}
		catch(Exception e) {
		System.out.println("Not a valid number!");
		}
	}


	@Override
	public Boolean upper(Boolean uppercase) {
		return uppercase;
	}


	@Override
	public String changeLower(String low) {
		return low.toUpperCase();
	}


	@Override
	public int addLower(int stringlow, int num) {
		return stringlow+num;
	}

}
