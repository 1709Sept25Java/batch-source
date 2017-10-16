package com.JDBCBank.Sessions;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.JDBCBank.DAO.*;
import com.JDBCBank.domain.*;
import com.JDBCBank.exceptions.AccountNotEmptyException;
import com.JDBCBank.exceptions.OverdraftException;
import com.JDBCBank.main.Driver;

public class UserOptions {

	static boolean isLoggedIn = true;
	
	public static void userSession(String username, String password) {
		
		Driver dr = new Driver();
		Scanner sc = dr.getScanner();
		
		while(isLoggedIn) {
			
			System.out.println("enter any of the following optionts.");
			System.out.println("1 - VIEW ALL ACCOUNTS");
			System.out.println("2 - CREATE NEW BANK ACCOUNT");
			System.out.println("3 - DELETE BANK ACCOUNT");
			System.out.println("4 - WTIHDRAW MONEY");
			System.out.println("5 - DEPOSIT MONEY");
			System.out.println("6 - VIEW TRANSACTION HISTORY");
			System.out.println("7 - LOGOUT");
			
			int in = sc.nextInt();
			
			switch(in) {
				case 1:
					List<BankAccount> bal = new ArrayList<BankAccount>();
					BankAcountDao bd = new BankAccountDaoImpl();
					UsersDao ud = new UserDaoImpl();
					int id = ud.getUserId(username, password);
					bal = bd.viewAllBankAccounts(id);
					for(BankAccount b: bal) {
						System.out.println("Bank Account ID: " + b.getBankAccountId() + " Balance: " + b.getBalance());
					}
					System.out.println("");
					break;
					
				case 2:
					int bl = 0;
					while(!(bl > 0)) {
						System.out.println("Amount for new account:");
						bl = sc.nextInt();
						if(bl > 0) {
							UsersDao newUD = new UserDaoImpl();
							int u_id = newUD.getUserId(username, password);
							BankAcountDao bd1 = new BankAccountDaoImpl();
							int create = bd1.createBankAccount(u_id, bl);
							System.out.println("New bank account created.");
						}
						else {
							System.out.println("Invalid input. Please enter an amount greater than 0.");
						}
						System.out.println("");
					}
					break;
					
				case 3:
					System.out.println("Bank Account ID:");
					int id1 = sc.nextInt();
					BankAcountDao bd1 = new BankAccountDaoImpl();
					try {
						int del = bd1.deleteBankAccount(id1);
					} catch (AccountNotEmptyException e) {
						e.printStackTrace();
					}
					System.out.println("Successfully deleted bank account " + id1 + ".");
					System.out.println("");
					break;
					
				case 4:
					System.out.println("Bank Account ID:");
					int id3 = sc.nextInt();
					System.out.println("Amount to withdraw:");
					int amt = sc.nextInt();
					BankAcountDao bd2 = new BankAccountDaoImpl();
					try {
						int withdraw = bd2.withdrawFromBankAccount(id3, amt);
					} catch (OverdraftException e) {
						e.printStackTrace();
					}
					System.out.println("Withdrew $" + amt + " from Bank Account " + id3 + ".");
					System.out.println("");
					break;
				
				case 5:
					System.out.println("Bank Account ID:");
					int id4 = sc.nextInt();
					System.out.println("Amount to deposit:");
					int amt1 = sc.nextInt();
					BankAcountDao bd3 = new BankAccountDaoImpl();
					int deposit = bd3.depositToBankAccount(id4, amt1);
					System.out.println("Deposited $" + amt1 + " to Bank Account " + id4 + ".");
					System.out.println("");
					break;	
				case 6:
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
