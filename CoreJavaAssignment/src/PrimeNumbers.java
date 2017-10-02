import java.util.ArrayList;
import java.util.stream.IntStream;

//Question 9
public class PrimeNumbers {
	public static void findingPrimes() {
		int x = 101;
        ArrayList<Integer> num = new ArrayList<Integer>();
        for(int j = 1; j<x;j++){
            num.add(j);
        }
        for(int i = 0;i<num.size();i++){
            boolean isPrime = true;
            if(num.get(i) == 1){
                isPrime = false;
            }else{
                for(int j = 2; j<num.get(i);j++){
                    if(num.get(i) % j == 0){
                        isPrime = false;
                        break;
                    
                    }
                }
            }
            if(isPrime){
                System.out.print(num.get(i) + " ");
            }
        }
	
	}
    public static void main(String[] args) {
       findingPrimes();
    }
}
