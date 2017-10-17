package com.revature.JDBCBank;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import com.revature.ConnectionUtil.Connect;

public class App {
	
	public static void main(String[] args) {

		//test connection
		try {
			Connection c = Connect.getConnection();
			c.setAutoCommit(false);
			System.out.println(c.getAutoCommit());
			if (c.isClosed() == false) {
				c.close();
			} else {

			}
			System.out.println(c.isClosed());

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		};
		
		

	}
}
