package junit.demo;

public class Calculator 
{
	/*
	 *Requirement 1: create a String calculator with a method int add(String numbers)
	 *The method can take 0,1, or 2 numbers, demlimited by a comma ,
	 */
	
	public static int add(String numbers) {
		int sum=0;
		String[] numbersArray= numbers.split(",");
		if(numbersArray.length>2)
		{
			//this could be a custom checked exception too
			throw new RuntimeException("too many numbers");
		}
		else
		{
			for(String number: numbersArray) {
				if(!number.equals("")) {
					//shorthand for sum=sum+...things...
					sum+= Integer.parseInt(number);
				}
				else
				{
					continue;
				}
			}
		}
		
		return sum;
	}
}
