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
	public Users login(String username, String password,ConnectionUtil cu) {
		CallableStatement cs = null;
		Users u = null;
		
		try(Connection conn = cu.getConnected()){
			
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
	public List<Users> getUsers(int id,ConnectionUtil cu) {
		List<Users> u = null;
		CallableStatement cs = null;
		
		try(Connection conn = cu.getConnected()){
			String sql = "{call VIEW_USERS(?)}";
			cs = conn.prepareCall(sql);
			cs.setInt(1, id);
			ResultSet rs = cs.executeQuery();
			
			while(rs.next()) {
				Users newU;
				int uId = rs.getInt("USER_ID");
				String uName = rs.getString("USERNAME");
				String fname = rs.getString("FIRST_NAME");
				String lname = rs.getString("LAST_NAME");
				String admin = rs.getString("IS_ADMIN");
				boolean isAdmin = false;
				if(admin.equals("T")) {
					isAdmin = true;
				}
				newU = new Users(uId,uName,fname,lname,isAdmin);
				u.add(newU);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		return u;
	}

	@Override
	public boolean deleteUser(int id,ConnectionUtil cu) {
		
		CallableStatement cs = null;
		try(Connection conn = cu.getConnected()){
			
			String sql = "{call DELETE_USERS(?)}";
			cs = conn.prepareCall(sql);
			cs.setInt(1, id);
			cs.registerOutParameter(2, java.sql.Types.NUMERIC);
			
			cs.executeUpdate();
			
			int result = cs.getInt(2);
			if(result == -1) {
				return false;
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return true;
	}

	@Override
	public boolean createUser(String username, String password,String isAdmin,ConnectionUtil cu) {
		
		CallableStatement cs = null;
		
		try(Connection conn = cu.getConnected()){
			
			String sql = "{call INSERT_USERS(?,?)}";
			cs = conn.prepareCall(sql);
			cs.setString(1, username);
			cs.setString(2, password);
			cs.setString(3, isAdmin);
			cs.registerOutParameter(4, java.sql.Types.NUMERIC);
			
			cs.executeUpdate();
			
			int result = cs.getInt(4);
			if(result == -1) {
				return false;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return true;
	}

}
