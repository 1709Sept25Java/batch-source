package com.revature.ERS_DAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.util.Connect;

public class UserDaoImpl {

	public UserDaoImpl() {
		super();
	}
	
	private String username;
	private String password;
	
	public void verifyUser(String username,String password) {
		
		Boolean isValidUser = null;
		
		Connection c;
		try {
			c = Connect.getConnection();
			PreparedStatement p = c.prepareStatement("SELECT * FROM EMPLOYEES WHERE USERNAME = ? AND PW = ?");
			p.setString(1, username);
			p.setString(2, password);
			ResultSet rs = p.executeQuery();
			
			if(rs.next()) {
				isValidUser = true;
				System.out.println(isValidUser);
			} else {
				isValidUser = false;
				System.out.println(isValidUser);
			}
			c.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	};

}
