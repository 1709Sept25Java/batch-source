package corejava;

public class SubString {
	
	public static void subStr(String str, int idx) {
		String s = "";
		for(int i = 0; i < idx; i++) {
			s += str.charAt(i);//concatenate all letters from index 0 until idx exclusively 
		}
		System.out.println(s);
		
	}

	public static void main(String[] args) {
		subStr("apple", 3);

	}

}
