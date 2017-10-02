//question 13
public class Triangle {
	
	public static void makingTriangle() {
		int k=0;
		for(int i = 1; i <= 4; i++) {
			for(int j = 1; j<=i; j++) {
				
				if(k % 2==1) {
					System.out.print("1");
				}
				
				else {
					System.out.print("0");
				}
				k++;
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		makingTriangle();
		
	}
}
