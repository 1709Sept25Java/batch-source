package com.revature.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import junit.framework.TestCase;

public class ConnectionUtilTest extends TestCase {

	public void testConnection() {
		try {
			Connection con = ConnectionUtil.getConnectionFromFile();
			assertNotNull(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
