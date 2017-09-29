package corejava;

public class Concrete extends Abstract{


	public Concrete() {//constructor for Concrete class
		super();
	}
	
	@Override
	public boolean isThereUpper(String str) {
		int length = str.length();
		for(int i = 0; i < length; i++) { //checks to see if theres's any uppercases in the string
			if(Character.isUpperCase(str.charAt(i))){
				return true;
			}
		}
		return false;
		
	}

	@Override
	public String upper(String str) {
		return str.toUpperCase(); //turn lowercase letters to uppercase
		
	}

	@Override
	public int strToInt(String str) {
		int num = Integer.parseInt(str) + 10; //turns string into int and then add 10
		return num;
		
	}

}
