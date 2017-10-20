package com.revature.testconnection;

import static org.junit.Assert.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

import com.revature.util.ConnectionUtil;

public class ConnectionTest {

	@Test
	public final void testConn() {
		try {
			Connection conn = ConnectionUtil.getConnection();
			assertNotNull(conn);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
