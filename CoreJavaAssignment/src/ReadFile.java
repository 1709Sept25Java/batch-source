import java.io.*;
import java.lang.*;
import java.util.*;



public class ReadFile {
	
	private Scanner x; 
	
	public void openFile() {
		try {
			x = new Scanner(new File("Data.txt.txt"));
		}
		catch (Exception e) {
			System.out.println("error");
		}
	}
	public void readFile() {
		while(x.hasNext()) {
			String firstname = x.next();
			String lastname = x.next();
			String age = x.next();
			String state = x.next();
			System.out.printf("\nName: %s", firstname.split(":"));
			System.out.printf(" %s  ", lastname.split(":"));
			System.out.println("\n");
			System.out.printf("Age: %s years ", age.split(":"));
			System.out.println("\n");
			System.out.printf("State: %s state \n", state);
			
		}
		
	}
	public void closeFile() {
		x.close();
	}
}
