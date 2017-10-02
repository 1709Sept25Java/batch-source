//question 16
public class ReadCommandLine {

	public static void main(String[] args) {
		int count= 0;
        //String str = "Hello";
        for(int i = 0; i<args.length;i++){
            count++;
        }
        System.out.print(count);

	}

}
