//question 14
import java.util.ArrayList;
import java.util.Date;

public class Switch {

	public static void main(String[] args) {
		String text = new String();
		Date date = new Date();
		int number = 3;
		if (number == 1 || number == 2 || number == 3) {
			switch (number) {
			case 1:
				text = "Finding squart root";
				double x = 10;
				System.out.println("The square root of " + x + " is " + Math.sqrt(x));
				break;
			case 2:
				text = "Finding today's date";
				System.out.println("Today's date is " + date.toString());
				break;
			case 3:
				text = "Splitting string";
				String sen = "I am learning core Java";
				String[] words = sen.split(" ");
				ArrayList <String> s = new ArrayList<String>();
				for(String w: words) {
					s.add(w);
					System.out.println(w);
					
				}
				break;
			default: 
				text= "try again";
				break;
			}
		}

	}

}
