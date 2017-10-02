///Question 15
public class MathApplications implements MathApplicationsMain{
	
	
	public MathApplications() {
		super();
	}
	protected double x;
	protected double y;
	protected double sum = 0;
	
	public MathApplications(double x, double y, double sum) {
		this.x =x;
		this.y=x;
		this.sum=sum;
	}
	@Override
	public void addition() {
		x=5;
		y=4;
		sum=x+y;
		
		System.out.println("We are adding: " + x + " + " + y + " = " + sum);
	}
	@Override
	public void subtraction() {
		x= 10;
		y= 6;
		sum = x - y;
		System.out.println("We are subtracting: " + x + " - " + y + " = " +sum);
	}
	@Override
	public void multiplication() {
		x = 10;
		y = 2;
		for(int i = 1; i <= y ; i++) {
			sum+=x;
		}
		System.out.println("We are multiplying: " + x + " * " + y + " = " +sum);
	}
	@Override
	public void division() {
		x = 29;
		y = 3;
		double count = 0;
		double max = 0;
		System.out.print("We are dividing: " + x + " / " + y + " = ");
		while(x >= y) {
			x -= y; 
			count++;
		}
		double res = x%y;
		System.out.print(count + " remainder " + res);
		
		/*for(double i = 1; i<=x;i+=y) {
			
			x-=y;
			count++;
			if(count>max) {
				max = count;
			}
		}*/
		
		
	}
	

}
