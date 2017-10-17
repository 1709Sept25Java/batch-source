package com.oracle.test;

/*public class TestCode {

	public static void print() {
		
		int character = 1;
		
		for (int j = 1; j < 5; j++) { //loops for each row
			for (int i = 0; i < j; i++) { //make sure each row has the number of characters as its number of row
				if (character == 1) { //if statement alternates 0/1
					character = 0;
					System.out.print(character + " ");
					continue;
				}
				if (character == 0) {
					character = 1;
					System.out.print(character + " ");
				}
			}
			System.out.println();//creates a new line after the row is completed
		}
	}

	public static void main(String[] args) {
		print(); //calls the print function, printing out the triange
	}
}
*/

/*
public class TestCode{

public static void main(String[] args){

String[] arr = {"karen","madam","tom","civic","radar", "jimy","john","refer","billy","did"};
System.out.println("Original List: "+java.util.Arrays.toString(arr));
String[] res = palind(arr);
System.out.println("Palindrom List: "+java.util.Arrays.toString(res));
}

public static String[] palind(String[] arr){
    int count = 0;
    java.util.ArrayList<String> list = new java.util.ArrayList<String>();
    for(String s : arr){
            if(isPalindrome(s) == true){
                count++;
                list.add(s);
            }
        }
    String[] a = list.toArray(new String[count]);
    return a;
}

public static boolean isPalindrome(String s){
 return s.equals(new StringBuilder(s).reverse().toString());
}
}

*/