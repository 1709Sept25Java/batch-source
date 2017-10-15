package revature.project2hw;

import java.io.IOException;

public class IncorrectPwException extends Exception {
	//prints incorrect PW if the password is incorrect
	public IncorrectPwException(String message) {
        super(message);
    }
	
	public void IncorrectPWException(){
		System.out.println("Incorrect Pw");
	}
}
