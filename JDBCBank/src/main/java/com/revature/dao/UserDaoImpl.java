package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.connection.DatabaseConnection;
import com.revature.domain.Account;
import com.revature.domain.Transaction;
import com.revature.domain.User;

import oracle.jdbc.OracleTypes;

public class UserDaoImpl implements UserDao{

	int userID;
	Connection con;
	
	public UserDaoImpl(int id) {
		super();
		this.userID = id;
		this.con = DatabaseConnection.getConnection();
	}
	public Boolean createAccount(String type, int balance) {
		String create = "{call CREATE_ACCOUNT(?,?,?)}";
		CallableStatement pstmt;
		try {
			pstmt = this.con.prepareCall(create);
			pstmt.setInt(1,this.userID);
			pstmt.setString(2, type);
			pstmt.setInt(3, balance);
			pstmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

	public List<Account> viewAccounts() {
		ArrayList<Account> v1 = new ArrayList<Account>();
		String viewUsers = "{call VIEW_ACCOUNTS(?,?)}";
		CallableStatement pstmt;
		try {
			pstmt = this.con.prepareCall(viewUsers);
			pstmt.setInt(1,this.userID);
			pstmt.registerOutParameter(2, OracleTypes.CURSOR);
			pstmt.executeUpdate();
			ResultSet rs = (ResultSet) pstmt.getObject(2);
			while(rs.next()){
				int accountID = rs.getInt(1);
				String accountUser = rs.getString(2);
				String accountType = rs.getString(3);
				int balance = rs.getInt(4);
				String openDate = rs.getString(5);
				System.out.println(accountID+"\t"+accountUser+"\t"+accountType+"\t" + balance+"\t"+openDate);
			}		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return v1;
	}

	public List<Transaction> viewTransactions() {
		ArrayList<Transaction> v1 = new ArrayList<Transaction>();
		String viewTransactions = "{call VIEW_TRANSACTIONS(?,?)}";
		CallableStatement pstmt;
		try {
			pstmt = this.con.prepareCall(viewTransactions);
			pstmt.setInt(1,this.userID);
			pstmt.registerOutParameter(2, OracleTypes.CURSOR);
			pstmt.executeUpdate();
			ResultSet rs = (ResultSet) pstmt.getObject(2);
			while(rs.next()){
				int tID = rs.getInt(1);
				String tAccount = rs.getString(2);
				String tType = rs.getString(3);
				String tTime = rs.getString(4);
				int pBalance = rs.getInt(5);
				int cBalance = rs.getInt(6);
				System.out.println(tAccount+"\t"+tType+"\t"+tTime+"\t" + pBalance+"\t"+cBalance);
			}		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return v1;
	}

}
