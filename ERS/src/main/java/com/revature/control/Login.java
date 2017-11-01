package com.revature.control;

import java.io.PrintWriter;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.servlet.http.HttpSession;

import com.revature.domain.User;
import com.revature.util.ConnectionUtil;

import oracle.jdbc.OracleTypes;

//This class is used to login and determine user id + role 
//without direct interaction to database

public final class Login {

	private Login() {
		super();
	}

	//There is direct interaction with database instead of through DAO
	//because we still not determined whether user is employee or manager
	//but could be changed
	public static User login(String username, String password) {
		User user = null;
		try(Connection con = ConnectionUtil.getConnectionFromFile()) {
			String sql = "{call LOGIN(?,?,?)}";
			CallableStatement pstmt;
			pstmt = con.prepareCall(sql);
			pstmt.setString(1,username);
			pstmt.setString(2,password);
			pstmt.registerOutParameter(3, OracleTypes.CURSOR);
			pstmt.executeUpdate();
			ResultSet rs = (ResultSet) pstmt.getObject(3);
			while(rs.next()){
				int id = rs.getInt(1);
				String role = rs.getString(2);
				user = new User(id, username, role);
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}
}
