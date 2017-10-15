package bank.session;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import bank.dao.*;
import bank.domain.Users;
import bank.main.Driver;

public class AdminOptions {
	
	static boolean isLoggedIn = true;
	
	public static void adminSession(String username, String password) {
		
		Driver dr = new Driver();
		Scanner sc = dr.getScanner();
		
		while(isLoggedIn) {
			
			System.out.println("Please enter one of the following numbers. \n1 - VIEW ALL USERS"
					+"\n2 - CREATE A USER \n3 - UPDATE PASSWORD FOR A USER \n4 - DELETE A USER"
					+ "\n5 - LOGOUT");
			
			int in = sc.nextInt();
			
			switch(in) {
				case 1:
					List<Users> ul = new ArrayList<Users>();
					UsersDao ud = new UsersDaoImpl();
					ul = ud.getUsers();
					for(Users u: ul) {
						System.out.println("User ID: " + u.getUserId() + " User Type ID: " + u.getUserTypeId() + 
								" Username: " + u.getUsername() + " Password: " + u.getPassword());
					}
					System.out.println("");
					break;
					
				case 2:
					String an = "";
					while(!an.equals("user") && !an.equals("admin")){
						System.out.println("User or Admin?");
						an = sc.nextLine().toLowerCase();
						
						if(an.equals("user")) {
							System.out.println("Username for new user:");
							String un = sc.nextLine();
							System.out.println("Password for new user:");
							String pw = sc.nextLine();
							
							Users u = new Users(1, un, pw);
							UsersDao newU = new UsersDaoImpl();
							int i = newU.createUser(u);
							
							System.out.println("You have successfully created a new user.");
						}
						else if(an.equals("admin")) {
							System.out.println("Username for new admin:");
							String un = sc.nextLine();
							System.out.println("Password for new admin:");
							String pw = sc.nextLine();
							
							Users u = new Users(2, un, pw);
							UsersDao newU = new UsersDaoImpl();
							int i = newU.createUser(u);
							
							System.out.println("You have successfully created a new admin.");
						}
							
						System.out.println("Invalid option");
						System.out.println("");
					}
					break;
					
				case 3:
					System.out.println("User ID:");
					int id = sc.nextInt();
					System.out.println("New password:");
					sc.nextLine();
					String newPw = sc.nextLine().toUpperCase();
					UsersDao newU = new UsersDaoImpl();
					int pw = newU.updatePassword(id, newPw);
					System.out.println("Successfully updated password for user " + id + ".");
					System.out.println("");
					break;
					
				case 4:
					System.out.println("User ID:");
					int id1 = sc.nextInt();
					UsersDao newUD = new UsersDaoImpl();
					int del = newUD.deleteUser(id1);
					System.out.println("Successfully deleted user " + id1 + ".");
					System.out.println("");
					break;
					
				case 5:
					isLoggedIn = false;
					SessionOptions.endSession();
					break;
				
				default:
					System.out.println("Invalid option");
					System.out.println("");
					break;
			}
			
		}
	}
}
