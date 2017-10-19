package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.revature.bank.UserNotFoundException;
import com.revature.domain.Account;
import com.revature.domain.Transaction;

import oracle.jdbc.OracleTypes;

//AccountDao object is created from within CustomerDao
//The menu options we get for each account are:
//		1. deposit
//		2. withdraw, 
//		3. delete account
//		4. view transactions
//		5. logout
//Note that to view transactions we create a transaction dao 
//	that gives us a list of transaction for this account (using account id)
//  it does not give us all transactions for a user
//We always return to customer dao menu after a single transaction

public class AccountDaoImpl implements AccountDao {

	private int accountID;
	private Connection con;
	
	public AccountDaoImpl(Connection con, int id) {
		super();
		this.accountID = id;
		this.con = con;
	}
		
	//Controls interaction with account
	public void session() {
		System.out.println("Account: " + accountID);
		int option = accountMenu();
		accountCommand(option);
	}
	
	//Menu of things that can be done for each account
	//We call for user input via console
	//Future: validate user input
	private int accountMenu() {
		System.out.println("Account menu");
		String[] options = {"Deposit Account", "Withdraw Account", "Delete Account", "View Transactions"};
		Scanner sc = new Scanner(System.in);
		for (int i=0; i<options.length; i++) {
			System.out.println((i+1) + ". " + options[i]);
		}
        System.out.print("Please choose an option: ");
        String input = sc.nextLine();
        return Integer.parseInt(input)-1; //We display 1 to n options but array is 0 to n-1 index
	}
	
	//Switch case on user input from accountMenu method
	private void accountCommand(int option) {
		switch (option){
			case 0:
				depositAccount();
				break;
			case 1:
				try {
					//AccountOverDraftException
					withdrawAccount();
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case 2:
				deleteAccount();
				break;
			case 3:
				viewTransactions();
				break;
		}
	}
	
	//We delete the account we are viewing 
	//Note: we are sure account exists and we don't delete unless balance is zero
	//Future: throw exception if balance is not zero
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
	
	//Deposit + Withdraw: similar except withdraw throws an exception
	//User input via console
	public void depositAccount() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Amount to Deposit: ");
		int amount = Integer.parseInt(sc.next());
		String create = "{call ACCOUNT_DEPOSIT(?,?,?)}"; //Missing Parameter ?
		CallableStatement pstmt;
		try {
			pstmt = this.con.prepareCall(create);
			pstmt.setInt(1,this.accountID);
			pstmt.setInt(2, amount);
			pstmt.registerOutParameter(3, OracleTypes.NUMBER);
			pstmt.executeUpdate();
			int result = pstmt.getInt(3);
			if (result==0) {
				System.out.println("Successful deposit");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	//Deposit + Withdraw: similar except withdraw throws an exception
		//User input via console
	public void withdrawAccount() throws AccountOverdraftException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Amount to Withdraw: ");
		int amount = Integer.parseInt(sc.next());
		String create = "{call ACCOUNT_WITHDRAWAL(?,?,?)}";
		CallableStatement pstmt;
		try {
			pstmt = this.con.prepareCall(create);
			pstmt.setInt(1,this.accountID);
			pstmt.setInt(2, amount);
			pstmt.registerOutParameter(3, OracleTypes.NUMBER);
			pstmt.executeUpdate();
			int result = pstmt.getInt(3);
			if (result==0) {
				System.out.println("Withdraw success");
			}
			else {
				throw new AccountOverdraftException("Overdraft error");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//Allow to view transactions for this particular account
	//Call TransactionDao to get a list of transactions
	public void viewTransactions() {
		System.out.println("View transactions");
		TransactionDao transaction = new TransactionDaoImpl(con, this.accountID);
		ArrayList<Transaction> transactions = transaction.viewTransactions();
		if (transactions.size()==0) { //Might throw exception here
			System.out.println("No transactions for this account");
		}
		else {
			System.out.printf("%-10s %-10s %-10s %-10s\n","","type","previous","current","time");
			for (int i=0; i<transactions.size(); i++) {
				System.out.printf("%-10s %-10s\n",(i+1),transactions.get(i).toString());
			}
		}
	}
	
}