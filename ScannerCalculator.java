package inClassDemos;

import java.util.Scanner;

public class ScannerCalculator {

	public ScannerCalculator() {
		// TODO Auto-generated constructor stub
		super();
	}
	
	Scanner x = new Scanner(System.in);
	
	public ScannerCalculator(Number n1, Number n2) {
		
		static private String read() {
			System.out.println("Which datatype would you like to operate on?");
			
			String dataType = x.next();
			
			switch(dataType) {
			case("byte"): {
				// I could not figure out how to use the scanner object because I didn't understand that 
				// it would accept input from the console. So the examples I was looking at online didn't
				// make much sense. I will work on this some more and try again.
				break;
			};
			case("short"): {
				
				break;
			}
			case("int"): {
				
				break;
			}
			case("long"): {
				
				break;
			}
			case("float"): {
				
				break;
			}
			case("double"): {
				
				break;
			}
			else {
				System.out.println("Invalid data type entered.");
			}
			};
		};
		
		private Number add() {
			
		};
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
