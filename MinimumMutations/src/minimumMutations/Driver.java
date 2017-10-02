package minimumMutations;

import java.util.ArrayList;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String start = "AAACGGTA";
		String end = "AAACCCTT";
		
		ArrayList<String> bank = new ArrayList<String>(); 
		bank.add(start);
		bank.add(end);
		MinimumMutations mut = new MinimumMutations();
		System.out.println(mut.Mutation(start, end, bank));
	}

}
