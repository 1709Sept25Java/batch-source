package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.revature.domain.Account;
import com.revature.domain.User;

import oracle.jdbc.OracleTypes;

public class CustomerDaoImpl implements CustomerDao {

	int customerID;
	Connection con;	
	boolean login;
	List<Account> accounts;
	
	public CustomerDaoImpl(Connection con, int id) {
			super();
			this.customerID = id;
			this.con = con;
			this.login = true;
			this.accounts = getAccounts();
	}

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

	public void viewAccounts() {
		this.accounts = getAccounts();
		for (int i=0; i<accounts.size(); i++) {
			System.out.println((i+1)+"\t"+accounts.get(i).toString());
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

	public boolean loggedIn() {
		return login;
	}
	
	public void logout() {
		this.login = false;
	}
	
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

	public void accountTransactions() {
		Scanner sc = new Scanner(System.in);
		viewAccounts();
        System.out.println("Select Account");
        int option = Integer.parseInt(sc.next())-1;
        int ai = accounts.get(option).getAccountID();
        AccountDao account = new AccountDaoImpl(con, ai);
        account.session();
        
	}
	public void session() {
		System.out.println("Welcome Customer");
		int option;
		do {
			option = customerMenu();
			adminCommand(option);
		} while (option!=3);	
		logout();
	}
	
	public static int customerMenu() {
		System.out.println("Customer menu");
		String[] options = {"View Accounts","Create Account", "Account Transactions","Logout"};
		return userInput(options)-1;
	}

	public static int userInput(String[] options) {
		Scanner sc = new Scanner(System.in);
		for (int i=0; i<options.length; i++) {
			System.out.println((i+1) + ". " + options[i]);
		}
        System.out.print("Please choose an option: ");
        String input = sc.nextLine();
        return Integer.parseInt(input);
	}

}
