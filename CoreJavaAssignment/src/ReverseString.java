//Question 3
public class ReverseString {
	
	public static void reversing() {
		String name = "Betty";
		int length = name.length();
		for(int i = length; i > 0; --i)
		{
			System.out.print(name.charAt(i-1));
		}
	}
	public static void main(String[] args)
	{
		reversing();
		
	}
}
