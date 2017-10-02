
public class Question1 {
	public static void bubbles(int[] toSort){
		int a = toSort.length;
		int temp;
		for(int i = 0; i< a; i++)
		{
			for(int j = 1; j< a; j++) 
			{
				if(toSort[j] < toSort[j-1])
				{
					temp = toSort[j];
					toSort[j] = toSort[j-1];
					toSort[j-1] = temp; 
				}
			}
		}
		for(int i = 0; i<a; i++) {
			System.out.print(toSort[i] + " ");
		}		
	}
	public static void main(String[] args) {
		int[] toSort = new int [11];
		toSort[0] = 1;
		toSort[1] = 0;
		toSort[2] = 5;
		toSort[3] = 6;
		toSort[4] = 3;
		toSort[5] = 2;
		toSort[6] = 3;
		toSort[7] = 7;
		toSort[8] = 9;
		toSort[9] = 8;
		toSort[10] = 4;
		bubbles(toSort);
				
	}
}
