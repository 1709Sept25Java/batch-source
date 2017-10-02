import java.util.ArrayList;

public class Question19 {

	public static void main(String[] args) throws IndexOutOfBoundsException{
		ArrayList <Integer>numbers = new ArrayList<Integer> (); 
		for(int i = 1; i< 11; i++) {
			numbers.add(i);
		}
		System.out.println("Inserting integers " + numbers + " ");
		
		// adding even numbers
		int sum = 0;
		for(int j : numbers) {
			if(j %2 == 0) {
			 sum += j;
			}
		}
		System.out.println("The sum of even numbers is: " + sum);
		//adding odd numbers
		int sum2 =0;
		for(int k : numbers) {
			if(k%2!=0) {
				sum2+=k;
			}
		}
		System.out.println("The sum of odd numbers is: " + sum2);
		
		//remove prime numbers
		for(int i = 0;i<numbers.size();i++){
			boolean isPrime = true;
			if(numbers.get(i) == 1){
				isPrime = false;
			} else {
				for (int j = 2; j<numbers.get(i) ; j++) {
					if(numbers.get(i) % j == 0) {
					isPrime = false;
					break;
					}
				}
			}
			if(isPrime) {
				//System.out.print(numbers.get(i) + " ");
				numbers.remove(i);
			}
		}
		System.out.print(numbers + " ");
	}

}
