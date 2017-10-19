package com.revature.util;

import static org.junit.Assert.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

public class ConnectionUtilTest {

	@Test
	public final void testDatabaseConnection() {
		Connection con = null;
		try {
			con =  ConnectionUtil.getConnectionFromFile();
			assertNotNull(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public final void testDatabaseStatement() {
		Connection con = null;
		try {
			con =  ConnectionUtil.getConnectionFromFile();
			String sql = "SELECT * FROM REIMBURSEMENTS";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			assertNotNull(rs);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
}
