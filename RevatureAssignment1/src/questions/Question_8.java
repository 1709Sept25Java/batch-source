package questions;

import java.util.ArrayList;

/**Write a program 
that stores the following strings in an ArrayList and saves all the palindromes in another ArrayList.
“karan”, “madam”, ”tom”, “civic”, “radar”, “jimmy”, “kayak”, “john”,  “refer”, “billy”, “did”
**/

public class Question_8 {
	public static void main (String[]args) {
		paldms();
	}
	public static void paldms()
	{
		ArrayList names= new ArrayList();
		
		names.add("karan");
		names.add("madam");
		names.add("tom");
		names.add("civic");
		names.add("radar");
		names.add("jimmy");
		names.add("kayak");
		names.add("john");
		names.add("refer");
		names.add("billy");
		names.add("did");
		
		System.out.println("Arraylist1: "+names);
		
		ArrayList names2= new ArrayList();
		
		names2.addAll(names);
		
		System.out.println("Arraylist1 copy: "+names2);
		
	}
}
