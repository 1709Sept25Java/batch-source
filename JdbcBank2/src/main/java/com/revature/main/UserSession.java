package com.revature.main;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.revature.dao.BankAccountDao;
import com.revature.dao.BankAccountDaoImpl;
import com.revature.domain.BankAccount;
import com.revature.domain.Users;
import com.revature.exception.OverdraftException;

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
		
		
		
		while(user != null) {
			System.out.println("Please select an item from the list below:");
			System.out.println("\t 1) Create new account");
			System.out.println("\t 2) Delete account");
			System.out.println("\t 3) Deposit int an account");
			System.out.println("\t 4) Withdraw from an account");
			System.out.println("\t 5) Log out");
			
			int choice = Integer.parseInt(sc.nextLine());
			
			switch (choice){
			case 1:
				boolean created = baDao.createAccount(user.getId());
				if(created) {
					System.out.println("You have successfully created a new account!");
				} else {
					System.out.println("An error has occured!");
				}
				break;
			case 2:
				if(!accounts.isEmpty()) {
					userDeleteAccount(user,baDao,accounts);
					break;
				} else {
					System.out.println("You have no accounts to delete");
					break;
				}
			case 3:
				
				if(!accounts.isEmpty()) {
					
					userDeposit(user,sc,baDao,accounts);
					
				} else {
					System.out.println("You have no accounts to deposit to");
				}
				break;
			case 4:
				if(!accounts.isEmpty()) {
					
					userWithdraw(user,sc,baDao,accounts);
					
				} else {
					System.out.println("You have no accounts to withdraw from");
				}
				break;
			case 5:
				user = null;
				break;
			default:
				System.out.println("This is not a menu item!");
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
			if(b.getId() == baId && b.getBalance() != 0) {
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
	
	public static void adminSession(Users user, Scanner sc) {
		
		//Call to show all use accounts
		
		System.out.println("Please select an item from the list below:");
		System.out.println("\t 1) Create new user");
		System.out.println("\t 2) Delete a user");
		System.out.println("\t 3) Alter user rights");
	}

}
