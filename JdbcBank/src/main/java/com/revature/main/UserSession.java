package com.revature.main;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.revature.dao.BankAccountDao;
import com.revature.dao.BankAccountDaoImpl;
import com.revature.dao.UsersDao;
import com.revature.dao.UsersDaoImpl;
import com.revature.domain.BankAccount;
import com.revature.domain.Users;
import com.revature.exception.OverdraftException;
import com.revature.exception.PasswordMismatchException;
import com.revature.exception.UserNotCreatedException;

/*
 * Function that controls a user session for the bank
 * */
public class UserSession {
	
	public static void userSession(Users user, Scanner sc) {
		
		//Call to show user accounts!!!
		BankAccountDao baDao = new BankAccountDaoImpl();
		List<BankAccount> accounts = baDao.getAccounts(user.getId());
		if(!accounts.isEmpty()) {
			for(BankAccount b : accounts) {
				System.out.println(b.toString());
			}
		} else {
			System.out.println("You have no accounts.");
		}
		
		//Loop to continue displaying options until the user logs out
		while(user != null) {
			//Menu options
			System.out.println("Please select an item from the list below:");
			System.out.println("\t 1) Create new account");
			System.out.println("\t 2) Delete account");
			System.out.println("\t 3) Deposit int an account");
			System.out.println("\t 4) Withdraw from an account");
			System.out.println("\t 5) Log out of the Intergalactic Bank of Prosper");
			
			int choice = Integer.parseInt(sc.nextLine());
			//Switch to perform user desired function
			switch (choice){
			case 1:
				boolean created = baDao.createAccount(user.getId());
				//Let the user know if the account was successfully created
				if(created) {
					System.out.println("You have successfully created a new account!");
				} else {
					System.out.println("An error has occured!");
				}
				break;
			case 2:
				//Check that the user has accounts before calling the delete function
				if(!accounts.isEmpty()) {
					userDeleteAccount(user,baDao,accounts);
					break;
				} else {
					System.out.println("You have no accounts to delete");
					break;
				}
			case 3:
				//Check that the user has an account before giving them deposit options
				if(!accounts.isEmpty()) {
					userDeposit(user,sc,baDao,accounts);
					
				} else {
					System.out.println("You have no accounts to deposit to");
				}
				break;
			case 4:
				//Check that the user had an account before giving them withdrawal options
				if(!accounts.isEmpty()) {
					userWithdraw(user,sc,baDao,accounts);
					
				} else {
					System.out.println("You have no accounts to withdraw from");
				}
				break;
			case 5:
				//Break the loop to end the user session
				user = null;
				break;
			default:
				System.out.println("This is not a menu item!");
				break;
			}
		}
			
	}
	
	/*
	 * Function that controls admin user sessions
	 * */
	public static void adminSession(Users user, Scanner sc) {
		
		//Call to show all use accounts
		UsersDao uDao = new UsersDaoImpl();
		List<Users> customers = uDao.getUsers(user.getId());
		if(!customers.isEmpty()) {
			for(Users u : customers) {
				System.out.println(u.toString());
			}
		} else {
			System.out.println("There are no user accounts!");
		}
		
		while(user != null) {
			//Admin menu options
			System.out.println("Please select an item from the list below:");
			System.out.println("\t 1) Create new user");
			System.out.println("\t 2) Delete a user");
			System.out.println("\t 3) Alter user rights");
			System.out.println("\t 4) Log out as Prosper Admin");
			int choice = Integer.parseInt(sc.nextLine());
			
			//Switch to perform actions desired by admin
			switch(choice) {
			case 1:
				try {
					adminCreateAccount(uDao,sc);
				} catch (PasswordMismatchException e) {
					e.printStackTrace();
				}
				break;
			case 2:
				admDeleteUser(uDao,sc,customers);
				break;
			case 3:
				admUpdateUser(uDao,sc,customers);
				break;
			case 4:
				user = null;
				break;
			default:
				System.out.println("Not a menu option, please try again!");
				break;
			}
			
		}
		
	}
	
	public static void userDeleteAccount(Users user, BankAccountDao baDao, List<BankAccount> accounts) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter the id of the account you wish to delete: ");
		int baId = Integer.parseInt(sc.nextLine());
		boolean deleted = false;
		
		Iterator<BankAccount> it = accounts.iterator();
		while(it.hasNext()) {
			BankAccount b = it.next();
			if(b.getId() == baId && b.getBalance() == 0) {
				deleted = baDao.deleteAccount(user.getId(), baId);
				it.remove();
			}
		}
		
		if(deleted) {
			System.out.println("Bank account "+ baId +" was successfully removed.");
		} else {
			System.out.println("I'm sorry an error occured!");
		}
	}
	
	public static void userDeposit(Users user, Scanner sc,BankAccountDao baDao,List<BankAccount> accounts) {
		//Get the user information for the account to deposit to
		System.out.println("Please give the id of the account you wish to deposit to:");
		int bId = Integer.parseInt(sc.nextLine());
		System.out.println("Please specify the amount you are depositing: ");
		int amt = Integer.parseInt(sc.nextLine());
		int newBal = 0;
		
		Iterator<BankAccount> it = accounts.iterator();
		while(it.hasNext()) {
			BankAccount b = it.next();
			
			if(b.getId() == bId) {
				newBal = baDao.deposit(b.getId(), amt);
				if(newBal != -1) {
					b.setBalance(newBal);
					System.out.println("New balance for account "+ bId +" is: "+newBal);
				} else {
					System.out.println("Oh no! Something went wrong!");
				}
			}
		}
		
		if(newBal == 0) {
			System.out.println("Oh no! Something went wrong!");
		}
		
	}
	
	public static void userWithdraw(Users user, Scanner sc,BankAccountDao baDao,List<BankAccount> accounts) {
		//Get the user information for the account to withdraw from
		System.out.println("Please give the id of the account you wish to withdraw from:");
		int bId = Integer.parseInt(sc.nextLine());
		System.out.println("Please specify the amount you are withdrawing: ");
		int amt = Integer.parseInt(sc.nextLine());
		int newBal = -1;
		
		Iterator<BankAccount> it = accounts.iterator();
		while(it.hasNext()) {
			BankAccount b = it.next();
			
			if(b.getId() == bId) {
				try {
					newBal = baDao.withdraw(b, amt);
				} catch (OverdraftException e) {
					System.out.println(e.getMessage());
				}
				if(newBal != -1) {
					b.setBalance(newBal);
					System.out.println("New balance for account "+ bId +" is: "+newBal);
				} else {
					System.out.println("Oh no! Something went wrong!");
				}
			}
		}
		
		if(newBal == -1) {
			System.out.println("Oh no! Something went wrong!");
		}
		
	}
	
	public static void adminCreateAccount(UsersDao uDao,Scanner sc) throws PasswordMismatchException {
		//Have the user set the username and password for their new account
				System.out.println("Create Account ");
				System.out.println("Username: ");
				String uname = sc.nextLine();
				System.out.println("Password: ");
				String pw = sc.nextLine();
				System.out.println("Verify password: ");
				String pwCheck = sc.nextLine();
				System.out.println("Is this user an admin(t/f): ");
				String adm = sc.nextLine();
				
				//Throw an exception if the password does not match
				if(!pw.equals(pwCheck)) {
					throw new PasswordMismatchException();
				}
				
				//Try to insert a new user into the database
				boolean create;
				try {
					create = uDao.createUser(uname,pw,adm);
					System.out.println("Please login: ");
					//Call the login function if the user is successfully inserted
					if(create) {
						System.out.println("User successfully added to the database");
					}
					
				} catch (UserNotCreatedException e) {
					e.printStackTrace();
				}
	}
	
	public static void admUpdateUser(UsersDao uDao, Scanner sc, List<Users> customers) {
		
		System.out.println("Please enter the id of the customer you wish to update: ");
		int uId = Integer.parseInt(sc.nextLine());
		boolean updated = false;
		
		Iterator<Users> it = customers.iterator();
		while(it.hasNext()) {
			Users u = it.next();
			
			if(u.getId() == uId) {
				if(u.isAdmin()) {
					updated = uDao.updateUser(u.getId(), "f");
					u.setAdmin(false);
				} else {
					updated = uDao.updateUser(u.getId(), "t");
					u.setAdmin(true);
				}
			}
		}
		
		if(updated) {
			System.out.println("Update success!");
		}
		
	}
	
	public static void admDeleteUser(UsersDao uDao,Scanner sc,List<Users> customers) {
		
		System.out.println("Please enter the id of the User you wish to delete: ");
		int uId = Integer.parseInt(sc.nextLine());
		boolean deleted = false;
		
		Iterator<Users> it = customers.iterator();
		while(it.hasNext()) {
			Users u = it.next();
			
			if(u.getId() == uId) {
				deleted = uDao.deleteUser(u.getId());
				it.remove();
			}
		}
		
		if(deleted) {
			System.out.println("User successfully deleted!");
		}
		
	}

}
