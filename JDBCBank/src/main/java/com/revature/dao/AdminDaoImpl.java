package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.connection.DatabaseConnection;
import com.revature.domain.User;

import oracle.jdbc.OracleTypes;

public class AdminDaoImpl implements AdminDao {
	
	int adminID;
	Connection con;
	
	public AdminDaoImpl(int id) {
		super();
		this.adminID = id;
		this.con = DatabaseConnection.getConnection();
	}

	//INCOMPLETE: NO RETURN OF USERS
	public ArrayList<User> viewUsers() {
		ArrayList<User> v1 = new ArrayList<User>();
		String viewUsers = "{call VIEW_USERS(?,?)}";
		CallableStatement pstmt;
		try {
			pstmt = this.con.prepareCall(viewUsers);
			pstmt.setInt(1,this.adminID);
			pstmt.registerOutParameter(2, OracleTypes.CURSOR);
			pstmt.executeUpdate();
			ResultSet rs = (ResultSet) pstmt.getObject(2);
			while(rs.next()){
				int userid = rs.getInt(1);
				String username = rs.getString(2);
				String usertype = rs.getString(3);
				System.out.println(userid+" \t"+username+" \t"+usertype);
			}		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return v1;
	}

	
	public int createUser(String un, String pw, String t) {
		String create = "{call CREATE_USER(?,?,?,?)}";
		CallableStatement pstmt;
		try {
			pstmt = this.con.prepareCall(create);
			pstmt.setInt(1,this.adminID);
			pstmt.setString(2, un);
			pstmt.setString(3, pw);
			pstmt.setString(4, t);
			pstmt.executeUpdate();
			return 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	public boolean updateUser(int ui, String un, String pw, String t) {		
		String create = "{call UPDATE_USER(?,?,?,?,?)}";
		CallableStatement pstmt;
		try {
			pstmt = this.con.prepareCall(create);
			pstmt.setInt(1,this.adminID);
			pstmt.setInt(2, ui);
			pstmt.setString(3, un);
			pstmt.setString(4, pw);
			pstmt.setString(5,t);
			pstmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

	public boolean deleteUser(int ui) {
		String create = "{call DELETE_USER(?,?)}";
		CallableStatement pstmt;
		try {
			pstmt = this.con.prepareCall(create);
			pstmt.setInt(1,this.adminID);
			pstmt.setInt(2, ui);
			pstmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
