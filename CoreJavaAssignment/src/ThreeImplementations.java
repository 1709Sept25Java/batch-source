//Question 18
public class ThreeImplementations extends Main{

	public void firstMethod() {
		//checking uppercase letters in a string
		String str = "Check";
		char c;
		for (int i = 0; i<str.length(); i++){
			c = str.charAt(i);
			if(Character.isUpperCase(c)) {
				System.out.println("True ");
			}else {
				System.out.println("False "); 
			}
		}
	}
	public void secondMethod() {
		//letters in cap
		String str = "parameters";
		System.out.println(str + " in uppercase is " + str.toUpperCase());
	}
	public void thirdMethod() {
		//length + 10
		String str1 = "method";
		int int1 = str1.length() + 10;
		System.out.println("the length of the word " + str1 + " + 10 is " + int1);
	}
}
