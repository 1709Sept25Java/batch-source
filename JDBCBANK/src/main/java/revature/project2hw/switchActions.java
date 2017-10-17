package revature.project2hw;

import java.sql.SQLException;
import java.util.Scanner;

public class switchActions {
	public static void switchA() throws SQLException {
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
						+ "\n4)View all"
						+ "\n5)Log out");
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
				SuperUser s=new SuperUser();
				s.ViewAll();
				break;
			case 5:
				System.out.println("Logged out!");
				break;
			}
			scan.close();
	}
}
