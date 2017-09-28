package corejava;

public class Triangle {

	public static void main(String[] args) {
		int before = 1;
		for(int i = 1; i < 5; i++) {//number of rows to print out 
			for(int j = 0; j < i; j++) { //determines amount of numbers printed
				if(before == 1) { //prints out 0 if number before is 1
					System.out.print(0 + " ");
					before = 0;
				}
				else { //prints out 1 if number last printed out was 0
					System.out.print(1 + " ");
					before = 1;
				}
			}
			System.out.println("");
		}

	}

}
