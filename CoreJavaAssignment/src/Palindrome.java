
//Question 8
import java.util.*;

public class Palindrome {

	public static void Palindrome() {
		ArrayList<String> list = new ArrayList<String>();
		list.add("tom");
		list.add("karan");
		list.add("madam");
		list.add("tom");
		list.add("civic");
		list.add("radar");
		list.add("jimmy");
		list.add("kayak");
		list.add("john");
		list.add("billy");
		list.add("did");
		// System.out.println(list);
		ArrayList<String> pal = new ArrayList<String>();
		
		int x = list.size();
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
			StringBuilder sb = new StringBuilder(list.get(i));
			StringBuilder sbReverse = sb.reverse();
			if (list.get(i).equals(String.valueOf(sbReverse))) {
				System.out.println("yes");
				pal.add(list.get(i));
			} else {
				System.out.println("no");
			}
			// System.out.println(pal);
		}
	}

	public static void main(String[] args) {
		Palindrome();
	}
}
