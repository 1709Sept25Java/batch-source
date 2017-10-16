import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		Connection con = null;
		try {

			con = Connections.getConnectionFromFile();
			System.out.println(con.getMetaData().getDriverName());
		} catch (Exception e) {
			e.printStackTrace();
		}

		int userid = 0;
		String user = "";
		String pass = "";
		int typeid = 0;

		int amount = 0;
		int bankidnum = 0;
		// Creating an account

		UserDao ud = new UserDaoImpl();
		Users u = new Users();
		// System.out.println(ud.adminCreate(user, pass, typeid));
		//System.out.println(ud.adminUpdate(userid, user, pass, typeid));
		// System.out.println(ud.adminDelete(userid));

		// System.out.println(ud.getUsers().toString());
		// System.out.println(ud.getUsers().toString());
		/*
		 * System.out.println(ud.createAccount(u));
		 * System.out.println(ud.login(user,pass));
		 * 
		 */ //
		// System.out.println(ud.createAccount(u));
		// System.out.println(ud.getUsersById(userid));
		// System.out.println(ud.login(user,pass));
		// get usertype and specific id

		UserTypeDao utd = new UserTypeDaoImpl();
		/*
		 * System.out.println(utd.getUserTypes().toString());
		 * System.out.println(utd.getUserTypeById(userid).toString());
		 */

		// bank account implementations
		BankAccountDao bad = new BankAccountDaoImpl();
		BankAccount ba = new BankAccount();
		// System.out.println(bad.deleteAccount(userid));

		while (true) {
			System.out.println("Pick a choice");
			System.out.println("1. create account");
			System.out.println("2. login");
			System.out.println("3. admin");
			System.out.println("0. logout");
			Scanner sc = new Scanner(System.in);
			int choice = sc.nextInt();

			if (choice == 1) {
				System.out.println(ud.createAccount(u));
				System.out.println(bad.createBankAccount(ba));
				System.out.println("1. perform transaction");
				System.out.println("2. logout");
				int sub1 = sc.nextInt();
				if (sub1 == 1) {
					System.out.println(bad.createBankAccount(ba));
					System.out.println(bad.getBankAccountById(userid));
					System.out.println(bad.transaction(userid, amount));
				} else if (sub1 == 2) {
					System.out.println("logging out");
					break;
				}
			} else if (choice == 2) {
				System.out.println(ud.login(user, pass));
				System.out.println("1. perform transaction");
				System.out.println("2. Delete Account");
				System.out.println("0. logout");
				int subl = sc.nextInt();
				if (subl == 1) {
					System.out.println(bad.createBankAccount(ba));
					System.out.println(bad.getBankAccountById(userid));
					System.out.println(bad.transaction(userid, amount));
				} else if (subl == 2) {
					System.out.println(bad.deleteAccount(userid));
				} else if (subl == 0) {
					System.out.println("logging out");
					break;
				}
			} else if (choice == 3) {
				System.out.println("1. get user by id");
				System.out.println("2. get all users");//
				System.out.println("3. get usertypes");
				System.out.println("4. get user type by id");
				System.out.println("5. get bank account by id");
				System.out.println("6. admin create");
				System.out.println("7. admin update");
				System.out.println("8. admin delete");
				System.out.println("0. log out");
				int subc = sc.nextInt();
				if (subc == 1) {
					System.out.println(ud.getUsersById(userid));
				} else if (subc == 2) {
					System.out.println(ud.getUsers().toString());
				} else if (subc == 3) {
					System.out.println(utd.getUserTypes().toString());
				} else if (subc == 4) {
					System.out.println(utd.getUserTypeById(userid).toString());
				} else if (subc == 5) {
					System.out.println(bad.getBankAccountById(userid));
				} else if (subc == 6) {
					System.out.println(ud.adminCreate(user, pass, typeid));
				} else if(subc ==7) {
					System.out.println(ud.adminUpdate(userid, user, pass, typeid));
				}else if (subc == 8) {
					System.out.println(ud.adminDelete(userid));
				} else if (subc == 0) {
					System.out.println("Logged out");
					break;
				}
			} else if (choice == 0) {
				System.out.println("Logged out");
				break;
			}
		}

	}

}
