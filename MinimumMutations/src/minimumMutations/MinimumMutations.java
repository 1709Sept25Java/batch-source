package minimumMutations;

import java.util.ArrayList;

public class MinimumMutations {
	public MinimumMutations() {
		super();
	}

	public int Mutation(String start, String end, ArrayList<String> bank) {

		int count = 0;

		if (start.equals(end)) {
			return 0;
		}

		for (int i = 0; i < start.length(); i++) {
			if (start.charAt(i) != end.charAt(i)) {
				count++;
			}
		}
		
		System.out.println(bank);

		if (count == 0) {
			return -1;
		}

		return count;
	}

}
