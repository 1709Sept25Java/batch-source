//Question 5
public class Substring {

	public static void substringing() {
		String str="hello";
		int itr= 3;
		char[] ch = str.toCharArray();
		for(int i = 0; i<ch.length-(itr- 1);i++) {
			System.out.print(ch[i]);
		}
	}
	public static void main(String[] args) {
		substringing();
			
	}

}
