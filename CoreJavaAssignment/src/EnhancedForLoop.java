//question 12
import java.util.stream.IntStream;

public class EnhancedForLoop {

	public static void looping() {
		int[] num = IntStream.range(1, 101).toArray();

		for (int x : num) {
			if (x % 2 == 0) {
				System.out.println(x);
			}
		}
	}
	public static void main(String[] args) {
		looping();
	}

}
