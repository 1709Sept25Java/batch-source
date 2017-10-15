package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.revature.domain.Account;
import com.revature.domain.Transaction;

import oracle.jdbc.OracleTypes;

public class AccountDaoImpl implements AccountDao {

	int accountID;
	Connection con;
	
	public AccountDaoImpl(Connection con, int id) {
		super();
		this.accountID = id;
		this.con = con;
	}
		
	public void session() {
		System.out.println("Account " + accountID);
		int option = accountMenu();
		accountCommand(option);
	}
	
	public int accountMenu() {
		System.out.println("Account menu");
		String[] options = {"Deposit Account", "Withdraw Account", "Delete Account", "View Transactions"};
		return userInput(options);
	}
	
	private void accountCommand(int option) {
		option = option-1;
		switch (option){
			case 0:
				depositAccount();
				break;
			case 1:
				withdrawAccount();
				break;
			case 2:
				deleteAccount();
				break;
			case 3:
				viewTransactions();
				break;
		}
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
	
	
	
	public void deleteAccount() {
		String viewUsers = "{call DELETE_ACCOUNT(?,?)}";
		CallableStatement pstmt;
		try {
			pstmt = this.con.prepareCall(viewUsers);
			pstmt.setInt(1,this.accountID);
			pstmt.registerOutParameter(2, OracleTypes.CURSOR);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void depositAccount() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Amount to Deposit: ");
		int amount = Integer.parseInt(sc.next());
		
		String create = "{call ACCOUNT_DEPOSIT(?,?)}";
		CallableStatement pstmt;
		try {
			pstmt = this.con.prepareCall(create);
			pstmt.setInt(1,this.accountID);
			pstmt.setInt(2, amount);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void withdrawAccount() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Amount to Deposit: ");
		int amount = Integer.parseInt(sc.next());
		String create = "{call ACCOUNT_WITHDRAWAL(?,?)}";
		CallableStatement pstmt;
		try {
			pstmt = this.con.prepareCall(create);
			pstmt.setInt(1,this.accountID);
			pstmt.setInt(2, amount);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void viewTransactions() {
		System.out.println("View transactions");
		TransactionDao transaction = new TransactionDaoImpl(con, this.accountID);
		ArrayList<Transaction> transactions = transaction.viewTransactions();
		if (transactions.size()==0) {
			System.out.println("No transactions for this account");
		}
		for (int i=0; i<transactions.size(); i++) {
			System.out.println((i+1)+"\t"+transactions.get(i).toString());
		}
	}


	
}