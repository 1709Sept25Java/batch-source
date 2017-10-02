import Question11.Question11;

public class Question11P2 extends Question11{
	public void sub() {
		sum = x-r;
		System.out.println("Subtracting: " + x + " - "+ r + " = "+ sum);
	}
	
	public static void main(String[] args) {
		Question11P2 p2 = new Question11P2();
		p2.sum = 0;
		p2.x = (float) 10.5556766553;
		p2.r = (float) 4.5565544573;
		p2.sub();
	}

}
