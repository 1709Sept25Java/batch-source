package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.revature.domain.Account;

import oracle.jdbc.OracleTypes;

public class AccountDaoImpl implements AccountDao {

	int accountID;
	Connection con;
	public AccountDaoImpl(Connection con, int id) {
		super();
		this.accountID = id;
		this.con = con;
	}
	
	public Boolean deleteAccount() {
		String viewUsers = "{call DELETE_ACCOUNT(?,?)}";
		CallableStatement pstmt;
		try {
			pstmt = this.con.prepareCall(viewUsers);
			pstmt.setInt(1,this.accountID);
			pstmt.registerOutParameter(2, OracleTypes.CURSOR);
			pstmt.executeUpdate();
//			ResultSet rs = (ResultSet) pstmt.getObject(2);
//			while(rs.next()){
//				int userid = rs.getInt(1);
//				String username = rs.getString(2);
//				String usertype = rs.getString(3);
//				System.out.println(userid+" \t"+username+" \t"+usertype);
//			}	
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public Boolean depositAccount(int amount) {
		String create = "{call ACCOUNT_DEPOSIT(?,?)}";
		CallableStatement pstmt;
		try {
			pstmt = this.con.prepareCall(create);
			pstmt.setInt(1,this.accountID);
			pstmt.setInt(2, amount);
			pstmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public Boolean withdrawAccount(int amount) {
		String create = "{call ACCOUNT_WITHDRAWAL(?,?)}";
		CallableStatement pstmt;
		try {
			pstmt = this.con.prepareCall(create);
			pstmt.setInt(1,this.accountID);
			pstmt.setInt(2, amount);
			pstmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	
}