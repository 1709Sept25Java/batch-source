package logging.demo;

public class App {
	public static void main(String []args)
	{
		System.out.println("Hello World");
		LoggingActionsClass logger= new LoggingActionsClass();
		logger.someMethod();
	
	try {
		exceptionThrowingGarbage();
	}
	catch(RuntimeException r){
		logger.giveFatal(r);
	}
	}
	
	public static void exceptionThrowingGarbage()
	{
		int i=5/0;
	}
	
}
