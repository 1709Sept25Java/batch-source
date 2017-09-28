package corejava;
import java.util.*;

public class Palindrome {
	
	public static boolean isPalindrome (String str) {
		int length = str.length();
		for(int i = 0; i < length; i++) {
			if(str.charAt(i) != str.charAt(length-1)) { //check to see if first letter is the same as last and so on
				return false;
			}
			length--; //decrement to correspond to mirror current position of the char being checked
		}
		return true;
	}
	public static ArrayList<String> paliArrayList(String[] al){
		int length = al.length;
		ArrayList<String> pali = new ArrayList<String>();
		for(int i = 0; i < length; i++) { //traverse through ArrayList to find palindrome
			if(isPalindrome(al[i]) == true) {
				pali.add(al[i]);
			}
		}
		return pali;
	}
	
	public static ArrayList<String> regArrayList(String[] al){
		int length = al.length;
		ArrayList<String> reg = new ArrayList<String>();
		for(int i = 0; i < length; i++) { //traverse through ArrayList to find non-palindrome
			if(isPalindrome(al[i]) == false) {
				reg.add(al[i]);
			}
		}
		return reg;
	}

	public static void main(String[] args) {
		String[] al = new String[] {"karan", "madam", "tom", "civic", "radar", "kayak", "john", "refer", "billy", "did"};
		ArrayList<String> pali = new ArrayList<String>();
		ArrayList<String> reg = new ArrayList<String>();
		pali = paliArrayList(al);
		reg = regArrayList(al);
		Iterator<String> i1 = pali.iterator(); //used to traverse through ArrayList
		Iterator<String> i2 = reg.iterator();
		
		
		System.out.print("Palindrome ArrayList: ");
		while(i1.hasNext()) {
			System.out.print(i1.next() + " "); //print out all palindromes
		}
		System.out.println();
		System.out.print("Regular ArrayList: ");
		while(i2.hasNext()) {
			System.out.print(i2.next() + " "); //print out all non-palindromes
		}
		
	}

}
