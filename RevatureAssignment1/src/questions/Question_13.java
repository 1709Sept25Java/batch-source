package questions;
/** Display the triangle on the console as follows using any type of loop.  
 * Do NOT use a simple group of print statements to accomplish this.
    0      		    1
    1 0		  		2
    1 0 1     		3
    0 1 0 1   		4
 */

public class Question_13 
{
	public static void main (String []args) {
		tri();	
	}
	
	public static void tri() 
	{
		int num = 0;
		for (int i=0; i<4; i++) {
			
			for (int x=0; x<(i+1); x++) {
				
				if (num==0) {
					System.out.print(num + " ");
					num = 1;
				}
				else {
					System.out.print(num + " ");
					num = 0; 
				}
			}
			System.out.println();
		}
	}
}
