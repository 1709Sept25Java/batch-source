package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

import com.revature.domain.User;
import com.revature.util.ConnectionUtil;

import oracle.jdbc.OracleTypes;

public class UserDaoImpl implements UserDao {

	public UserDaoImpl() {
		super();
	}
	
	@Override
	public User getUserById(int id) {
		User user = null;
		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			String sql = "{call USER_INFORMATION(?,?)}";
			CallableStatement pstmt;
			pstmt = con.prepareCall(sql);
			pstmt.setInt(1, id);
			pstmt.registerOutParameter(2, OracleTypes.CURSOR);
			pstmt.executeQuery();
			ResultSet rs = (ResultSet) pstmt.getObject(2);
			while (rs.next()) {
				String username = rs.getString(1);
				String firstName = rs.getString(2);
				String lastName = rs.getString(3);
				String email = rs.getString(4);
				String role = rs.getString(5);
				user = new User(id, username, firstName, lastName, email, role);
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return user;
	}
	
	@Override
	public int updateEmployeeById(int id, String un, String pw, String fn, String ln, String em) {
		String sql = "{call UPDATE_USER(?,?,?,?,?,?,?)}";
		CallableStatement pstmt;
		int success = 0;
		try(Connection con = ConnectionUtil.getConnectionFromFile()) {
			pstmt = con.prepareCall(sql);
			pstmt.setInt(1,id);
			pstmt.setString(2, un);
			pstmt.setString(3, pw);
			pstmt.setString(4, fn);
			pstmt.setString(5, ln);
			pstmt.setString(6, em);
			pstmt.registerOutParameter(7, OracleTypes.NUMBER);
			pstmt.executeUpdate();
			ResultSet rs = (ResultSet) pstmt.getObject(7);
			while(rs.next()){
				success = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return success;
	}

}
