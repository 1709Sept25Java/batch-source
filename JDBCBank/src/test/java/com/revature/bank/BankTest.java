package com.revature.bank;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.revature.connection.DatabaseConnection;
import com.revature.domain.User;

import junit.framework.Assert;

import static org.junit.Assert.*;

import org.junit.Test;

import oracle.jdbc.OracleTypes;

public class BankTest {

	@Test 
	public final void loginTest() {
		Connection con = DatabaseConnection.getConnection();
		ArrayList<String> results = new ArrayList<String>();
		results.add("blah");
		results.add("blah");
		CallableStatement pstmt;
		ResultSet rs;
		User user = null;
		int result;
		String login = "{call LOGIN(?,?,?,?)}";
		try {
			pstmt = con.prepareCall(login);
			pstmt.setString(1, results.get(0));
			pstmt.setString(2, results.get(1));
			pstmt.registerOutParameter(3, OracleTypes.NUMBER);
			pstmt.registerOutParameter(4, OracleTypes.CURSOR);
			pstmt.executeUpdate();
			result = pstmt.getInt(3);
			if (result>0) {
				rs = (ResultSet) pstmt.getObject(4);
				while(rs.next()){
					int userid = rs.getInt(1);
					String usertype = rs.getString(2);
					user = new User(userid, usertype);
				}	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		assertNull(user);
	}

}
