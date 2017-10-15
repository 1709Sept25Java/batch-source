package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.revature.domain.Account;

import oracle.jdbc.OracleTypes;

//CustomerDao object is created from within Bank Session
//The menu options we get for customer are:
//		1. view accounts
//		2. create account
//		3. account transactions (must choose a single account to perform operation on)
//		4. logout
//Note that both admin & customer dao use User objects
//Until customer logs out, the customer can keep choosing a menu option
//Only the customer dao can access the account dao & transaction dao 
	//note that the transaction dao is accessed by an account dao - not directly by the customer dao

public class CustomerDaoImpl implements CustomerDao {

	private int customerID;
	private Connection con;	
	private boolean login;
	private List<Account> accounts;
	
	//Constructor needs connection and id of customer
	public CustomerDaoImpl(Connection con, int id) {
			super();
			this.customerID = id;
			this.con = con;
			this.login = true;
			this.accounts = getAccounts();
	}

	//Public methods for view accounts, create account, etc
	//Have corresponding private functions if needed
	public void viewAccounts() {
		this.accounts = getAccounts();
		System.out.printf("%-10s %-10s %-10s %-10s\n","","id","balance","type");
		for (int i=0; i<accounts.size(); i++) {	
			System.out.printf("%-10s %-10s\n",(i+1),accounts.get(i).toString());
		}
	}

	public void createAccount() {
		Scanner sc = new Scanner(System.in);
        System.out.println("Create Account");
        System.out.print("Account Type:");
        String type = sc.nextLine();
        System.out.print("Account Balance:");
        int balance = Integer.parseInt(sc.nextLine());
		String create = "{call CREATE_ACCOUNT(?,?,?)}";
		CallableStatement pstmt;
		try {
			pstmt = this.con.prepareCall(create);
			pstmt.setInt(1,this.customerID);
			pstmt.setString(2, type);
			pstmt.setInt(3, balance);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	public void accountTransactions() {
		Scanner sc = new Scanner(System.in);
		viewAccounts();
        System.out.println("Select Account");
        int option = Integer.parseInt(sc.next())-1;
        int ai = accounts.get(option).getAccountID();
        AccountDao account = new AccountDaoImpl(con, ai);
        account.session();
	}
	
	//Session method controls interactions with admin
	//Keep asking for input until admin logout
	public void session() {
		System.out.println("Welcome Customer");
		int option;
		do {
			option = customerMenu();
			adminCommand(option);
		} while (option!=3);	
		logout();
	}
	
	//Maintain loggedIn true
	public boolean loggedIn() {
		return login;
	}
	
	//Private method shows admin menu options & gets admin input
	private static int customerMenu() {
		System.out.println("Customer menu");
		String[] options = {"View Accounts","Create Account", "Account Transactions","Logout"};
		//Call for user input
		Scanner sc = new Scanner(System.in);
		for (int i=0; i<options.length; i++) {
			System.out.println((i+1) + ". " + options[i]);
		}
        System.out.print("Please choose an option: ");
        String input = sc.nextLine();
        return Integer.parseInt(input) - 1 ;
	}
	
	//Switch case to call methods
	private void adminCommand(int option) {
		switch (option){
			case 0:
				viewAccounts();
				break;
			case 1:
				createAccount();
				break;
			case 2:
				accountTransactions();
				break;
				
		}
	}
	
	//Get Accounts uses user id to get all accounts of a particular user	
	private ArrayList<Account> getAccounts() {
		ArrayList<Account> accounts = new ArrayList<Account>();
		String viewUsers = "{call VIEW_ACCOUNTS(?,?)}";
		CallableStatement pstmt;
		try {
			pstmt = this.con.prepareCall(viewUsers);
			pstmt.setInt(1,this.customerID);
			pstmt.registerOutParameter(2, OracleTypes.CURSOR);
			pstmt.executeUpdate();
			ResultSet rs = (ResultSet) pstmt.getObject(2);
			while(rs.next()){
				int accountID = rs.getInt(1);
				String username = rs.getString(2);
				String accounttype = rs.getString(3);
				int balance = rs.getInt(4);
				String opendate = rs.getString(5);
				Account account = new Account(accountID, username, accounttype, balance, opendate);
				accounts.add(account);
			}		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return accounts;
	}


	private void logout() {
		this.login = false;
	}
	
	
}
