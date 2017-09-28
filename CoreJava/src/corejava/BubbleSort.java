package corejava;
public class BubbleSort {

	public static void main(String [] args) {
		int[] toSort = new int[]{1,0,5,6,3,2,3,7,9,8,4};
		bubbles(toSort);
		
	}
	
	public static void bubbles(int[] toSort) {
		//sort any array of int values using the bubblesort algorithm 
		int j = toSort.length; 
		for(int i = 0; i < j; i++) { //different passes of the bubblesort 
			for(int k = 1; k < j; k++) { //traverse through array
				if(toSort[k] < toSort[k-1]) { //switch left and right numbers if left is greater 
					int temp = toSort[k-1];
					toSort[k-1] = toSort[k];
					toSort[k] = temp;
				}
			}
	}
	
		for(int i = 0; i < j; i++) {  //traverse through array and print out the numbers 
			System.out.print(toSort[i] + " ");
		}
	
	}
}
