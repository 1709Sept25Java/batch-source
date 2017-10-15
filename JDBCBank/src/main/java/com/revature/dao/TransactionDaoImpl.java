package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.revature.domain.Account;
import com.revature.domain.Transaction;

import oracle.jdbc.OracleTypes;

public class TransactionDaoImpl implements TransactionDao {
	private Connection con;
	private int accountID;
	
	//Constructor needs a connection and account id
	public TransactionDaoImpl(Connection con, int id) {
		this.con = con;
		this.accountID = id;
	}
	
	//Returns an array of Transaction objects
	public ArrayList<Transaction> viewTransactions() {
		ArrayList<Transaction> transactions = new ArrayList<Transaction>();
		String viewTransaction = "{call VIEW_TRANSACTIONS(?,?)}";
		CallableStatement pstmt;
		try {
			pstmt = this.con.prepareCall(viewTransaction);
			pstmt.setInt(1,this.accountID);
			pstmt.registerOutParameter(2, OracleTypes.CURSOR);
			pstmt.executeUpdate();
			ResultSet rs = (ResultSet) pstmt.getObject(2);
			while(rs.next()){
				int tID = rs.getInt(1);
				int tA = rs.getInt(2);
				String tType = rs.getString(3);
				String tTime = rs.getString(4);
				int pBalance = rs.getInt(5);
				int cBalance = rs.getInt(6);
				Transaction transaction = new Transaction(tID, tA, tType, pBalance, cBalance, tTime);
				transactions.add(transaction);
			}		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return transactions;
	}

}
