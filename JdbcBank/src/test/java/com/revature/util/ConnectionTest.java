package com.revature.util;

import static org.junit.Assert.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

public class ConnectionTest {

	@Test
	public final void testConnection() {
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
