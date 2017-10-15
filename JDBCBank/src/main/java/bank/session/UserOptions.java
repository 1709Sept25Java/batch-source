package bank.session;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import bank.dao.*;
import bank.domain.*;
import bank.exceptions.AccountNotEmptyException;
import bank.exceptions.OverdraftException;
import bank.main.Driver;

public class UserOptions {

	static boolean isLoggedIn = true;
	
	public static void userSession(String username, String password) {
		
		Driver dr = new Driver();
		Scanner sc = dr.getScanner();
		
		while(isLoggedIn) {
			
			System.out.println("Please enter one of the following numbers.");
			System.out.println("1 - VIEW ALL BANK ACCOUNTS");
			System.out.println("2 - CREATE NEW BANK ACCOUNT");
			System.out.println("3 - DELETE BANK ACCOUNT");
			System.out.println("4 - WTIHDRAW MONEY");
			System.out.println("5 - DEPOSIT MONEY");
			System.out.println("6 - VIEW TRANSACTION HISTORY");
			System.out.println("7 - LOGOUT");
			
			int in = sc.nextInt();
			
			switch(in) {
				case 1:
					List<BankAccounts> bl = new ArrayList<BankAccounts>();
					BankAccountsDao bd = new BankAccountsDaoImpl();
					UsersDao ud = new UsersDaoImpl();
					int id = ud.getUserId(username, password);
					bl = bd.viewAllBankAccounts(id);
					for(BankAccounts b: bl) {
						System.out.println("Bank Account ID: " + b.getBankAccountId() + " Balance: " + b.getBalance());
					}
					System.out.println("");
					break;
					
				case 2:
					int bal = 0;
					while(!(bal > 0)) {
						System.out.println("Amount for new account:");
						bal = sc.nextInt();
						if(bal > 0) {
							UsersDao newUD = new UsersDaoImpl();
							int u_id = newUD.getUserId(username, password);
							BankAccountsDao bd1 = new BankAccountsDaoImpl();
							int create = bd1.createBankAccount(u_id, bal);
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
					BankAccountsDao bd1 = new BankAccountsDaoImpl();
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
					BankAccountsDao bd2 = new BankAccountsDaoImpl();
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
					BankAccountsDao bd3 = new BankAccountsDaoImpl();
					int deposit = bd3.depositToBankAccount(id4, amt1);
					System.out.println("Deposited $" + amt1 + " to Bank Account " + id4 + ".");
					System.out.println("");
					break;
					
				case 6:
					System.out.println("Bank Account ID:");
					int id5 = sc.nextInt();
					TransactionsDao td = new TransactionDaoImpl();
					List<Transactions> tl = new ArrayList<Transactions>();
					try {
						tl = td.getTransactionsByBankAccId(id5);
					} catch (ParseException e) {
						e.printStackTrace();
					}
					for(Transactions t: tl) {
						System.out.println("Transaction ID: " + t.getTransactionId() + " Transaction Date: " + t.getDate()
						+ " Transaction Info: " + t.getInfo());
					}
					System.out.println("");
					break;
						
				case 7:
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
