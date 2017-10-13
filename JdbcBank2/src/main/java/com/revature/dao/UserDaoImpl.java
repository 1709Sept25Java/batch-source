package com.revature.dao;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.revature.domain.Users;
import com.revature.util.ConnectionUtil;

public class UserDaoImpl implements UsersDao{

	@Override
	public Users login(String username, String password) {
		CallableStatement cs = null;
		Users u = null;
		
		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "{call LOGIN(?,?)}";
			cs = conn.prepareCall(sql);
			cs.setString(1, username);
			cs.setString(2, password);
			
			ResultSet rs = cs.executeQuery();
			while(rs.next()) {
				int uId = rs.getInt("USER_ID");
				String uName = rs.getString("USERNAME");
				String fname = rs.getString("FIRST_NAME");
				String lname = rs.getString("LAST_NAME");
				String admin = rs.getString("IS_ADMIN");
				boolean isAdmin = false;
				if(admin.equals("T")) {
					isAdmin = true;
				}
				u = new Users(uId,uName,password,fname,lname,isAdmin);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return u;
	}

	@Override
	public List<Users> getUsers(int id) {
		
		return null;
	}

	@Override
	public boolean deleteUser(int id) {
		
		return false;
	}

	@Override
	public boolean createUser(String username, String password) {
		
		return false;
	}

}
