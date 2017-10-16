package revature.project2hw;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Scanner;

public class Driver {

	public static void main(String[] args) throws SQLException, IOException {
		//driver class
		/*
			A registered user can login with their username and password  
			An unregistered user can register by creating a username and password 
			A superuser can view, create, update, and delete all users.
			
			A user can view their own existing accounts and balances. 
			A user can create an account.
			A user can delete an account if it is empty.  
			A user can add to or withdraw from an account. 
			A user can execute multiple deposits or withdrawals in a session. 
			A user can logout. 		 
		 */
		
		switchActions();

		//StoredProcedureTest t=new StoredProcedureTest();
		//t.checkUser();
		//StoredProcedureTest spt= new StoredProcedureTest();
		//spt.checkUser();
		//remember transactions and callable statements for procedures
	}

	public static void switchActions() throws SQLException {
		Scanner scan= new Scanner(System.in);
		Boolean closing=true;
		int choice2 = 0;
		System.out.println("Select a number...."
				+ "\n1)Login"
				+ "\n2)Create an Account");
		int choice=scan.nextInt();
		switch(choice) {
		case 1:
			Login lg= new Login();
			if(lg.runCheckCredentials()) {
				System.out.println("Select a number...."
						+ "\n1)View Account"
						+ "\n2)Delete Account"
						+ "\n3)Create a Transaction"
						+ "\n4)End Transaction");
				choice2=scan.nextInt();
			}
			break;
		case 2:
			CreateUserPass cuser= new CreateUserPass();
			cuser.runCreateAcc();
			break;
		default:
			break;
		}
		
		while(closing) {
			switch(choice2) {
			case 1:
				ViewAcc vc= new ViewAcc();
				vc.ViewAccount();
				break;
			case 2:
				DeleteAccEmpty dacc= new DeleteAccEmpty();
				dacc.SelectAcc();
				break;
			case 3:
				System.out.println("Transaction");
				break;
			case 4:
				closing=false;
				break;
			}
		}
	}

}
