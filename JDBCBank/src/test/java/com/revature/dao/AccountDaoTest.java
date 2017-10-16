package com.revature.dao;

import static org.junit.Assert.assertEquals;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import com.revature.connection.DatabaseConnection;

import oracle.jdbc.OracleTypes;

public class AccountDaoTest {

	public AccountDaoTest() {
		// TODO Auto-generated constructor stub
	}
	
	public void withdrawAccountTest() {
		Connection con = DatabaseConnection.getConnection();
		int amount = 1000000000;
		String create = "{call ACCOUNT_WITHDRAWAL(?,?)}";
		CallableStatement pstmt;
		int result = 10843984; //Testing for zero
		try {
			pstmt = con.prepareCall(create);
			pstmt.setInt(1, 7140); //Testable account id
			pstmt.setInt(2, amount);
			pstmt.registerOutParameter(3, OracleTypes.NUMBER);
			pstmt.executeUpdate();
			result = pstmt.getInt(3);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		assertEquals(result,0); 
	}

}
