package com.revature.main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import com.revature.util.ConnectionUtil;

public class Driver {
	
	public static void main(String[] args) {
		
		Connection con = null;
		
		try {
			con = ConnectionUtil.getConnection();
			
			System.out.println(con.getTransactionIsolation());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
