package questions;

public class Question_5 {
/**
 Write a substring method that 
 accepts a string str and an integer idx and returns the substring 
 contained between 0 and idx-1 inclusive.
 Do NOT use any of the existing substring methods in the String, StringBuilder, or StringBuffer APIs
 **/
	public static void main(String[] args) 
	{
		Question_5.returnSubstring("testing", 5);
	}
	
	public static void returnSubstring (String str, int idx)
	{ 
		char []ss=new char[idx];
			
			for (int i=0; i<idx-1; i++)
			{
				ss[i]=str.charAt(i);
			}
		System.out.println(ss);
	}
}
