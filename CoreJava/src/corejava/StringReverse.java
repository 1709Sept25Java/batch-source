package corejava;

public class StringReverse {

	public static void strReverse(String args) {
		int length = args.length(); 
		String s = "";
		for(int i = length-1; i >= 0; i--) {//start from the end of the string
			s = s + args.charAt(i); //concatenate letters starting from the end to a new string 
		}
		System.out.println(s);
	}
	
	public static void main(String[] args) {
		
		strReverse("apple");

	}

}
