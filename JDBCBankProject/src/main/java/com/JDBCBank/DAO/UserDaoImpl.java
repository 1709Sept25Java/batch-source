package com.JDBCBank.DAO;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.JDBCBank.domain.Users;
import com.JDBCBank.exceptions.InvalidPasswordException;
import com.JDBCBank.exceptions.UserDoesNotExistException;
import com.JDBCBank.util.JDBCBankConnection;

public class UserDaoImpl implements UsersDao{
	public List<Users> getUsers() {
		List<Users> ul = new ArrayList<Users>();
		
		try {
			JDBCBankConnection obj = JDBCBankConnection.getinstance();
			String sql = "SELECT * FROM USERS";
			Statement stmt = obj.establishedConnection().createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				int id = rs.getInt("USER_ID");
				int ut_id = rs.getInt("USER_TYPE_ID");
				String name = rs.getString("USER_NAME");
				String pw = rs.getString("USER_PASSWORD");
				Users newU = new Users(id, ut_id, name, pw);
				ul.add(newU);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(IOException e1) {
			e1.printStackTrace();
		}
		
		return ul;
	}
	
	public int getUserId(String username, String password) {
		
		PreparedStatement pstmt = null;
		int id = 0;
		
		try {
			JDBCBankConnection obj = JDBCBankConnection.getinstance();
			String sql = "SELECT USER_ID FROM USERS "
					+ "WHERE USER_NAME = ? AND USER_PASSWORD = ?";
			pstmt = obj.establishedConnection().prepareStatement(sql);
			pstmt.setString(1, username.toUpperCase());
			pstmt.setString(2, password.toUpperCase());
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				id = rs.getInt("USER_ID");
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}catch (IOException e1) {
			e1.printStackTrace();
		}
		
		return id;
	}

	public boolean isValidUser(String username, String password) throws UserDoesNotExistException, InvalidPasswordException {
		
		PreparedStatement pstmt = null;
		try {
			JDBCBankConnection obj = JDBCBankConnection.getinstance();
			String sql = "SELECT COUNT(USER_NAME) FROM USERS WHERE USER_NAME = ?";
			pstmt = obj.establishedConnection().prepareStatement(sql);
			pstmt.setString(1, username.toUpperCase());
			ResultSet rs = pstmt.executeQuery();
			int count_un = 0;
			while(rs.next()) {
				count_un = rs.getInt("COUNT(USER_NAME)");
			}
			if(count_un == 0) {
				throw new UserDoesNotExistException("USERNAME DOES NOT EXIST");
			}
			else if(!(isValidPassword(username, password))) {
				return false;
			}		
			else {
				return true;
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}catch (IOException e1) {
			e1.printStackTrace();
		}
		
		return false;
	}
	
	public boolean isValidPassword(String username, String password) throws InvalidPasswordException {
		
		PreparedStatement pstmt = null;
		JDBCBankConnection obj = JDBCBankConnection.getinstance();
		String sql = "SELECT USER_PASSWORD FROM USERS WHERE USER_NAME = ?";
		
		try {
			pstmt = obj.establishedConnection().prepareStatement(sql);
			pstmt.setString(1, username.toUpperCase());
			ResultSet rs = pstmt.executeQuery();
			String pw = "";
			while(rs.next()) {
				pw = rs.getString("USER_PASSWORD");
			}
			if(pw.equals(password.toUpperCase())) {
				return true;
			}
			else {
				throw new InvalidPasswordException("INVALID PASSWORD");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		return false;
	}

	public int getUserTypeId(String username) {
		
		PreparedStatement pstmt = null;
		int ut_id = 0;
		
		try {
			JDBCBankConnection obj = JDBCBankConnection.getinstance();
			String sql = "SELECT USER_TYPE_ID FROM USERS "
					+ "WHERE USER_NAME = ?";
			pstmt = obj.establishedConnection().prepareStatement(sql);
			pstmt.setString(1, username.toUpperCase());
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				ut_id = rs.getInt("USER_TYPE_ID");
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}catch (IOException e1) {
			e1.printStackTrace();
		}
		
		return ut_id;
	}

		public int createUser(Users usr) {
			
			JDBCBankConnection obj = JDBCBankConnection.getinstance();
			PreparedStatement pstmt = null;
			int usersCreated = 0;
			
			try {
				String sql = "{CALL REGISTER_NEW_USER(?, ?, ?)}";
				pstmt = obj.establishedConnection().prepareStatement(sql);
				pstmt.setInt(1, usr.getUserTypeId());
				pstmt.setString(2, usr.getUsername().toUpperCase());
				pstmt.setString(3, usr.getPassword().toUpperCase());
				usersCreated = pstmt.executeUpdate();
			}catch(SQLException e) {
				e.printStackTrace();
			}catch(IOException e) {
				e.printStackTrace();
			}
			
			return usersCreated; 
		}
		
		public int updatePassword(int u_id, String new_pw) {
			
			JDBCBankConnection obj = JDBCBankConnection.getinstance();
			PreparedStatement pstmt = null;
			int updated = 0;
			
			try {
				String sql = "{CALL UPDATE_PW(?, ?)}";
				pstmt = obj.establishedConnection().prepareStatement(sql);
				pstmt.setString(2, new_pw.toUpperCase());
				pstmt.setInt(1, u_id);
				updated = pstmt.executeUpdate();
			}catch(SQLException e) {
				e.printStackTrace();
			}catch(IOException e) {
				e.printStackTrace();
			}
			
			return updated;
		}
		
		public int deleteUser(int u_id) {
			
			JDBCBankConnection obj = JDBCBankConnection.getinstance();
			PreparedStatement pstmt = null;
			int deleted = 0;
			
			try {
				String sql = "{CALL DELETE_USER(?)}";
				pstmt = obj.establishedConnection().prepareStatement(sql);
				pstmt.setInt(1, u_id);
				deleted = pstmt.executeUpdate();
			}catch(SQLException e) {
				e.printStackTrace();
			}catch (IOException e) {
				e.printStackTrace();
			}
			return deleted;
		}

}
