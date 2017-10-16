package com.JDBCBank.DAO;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.JDBCBank.domain.UserTypes;
import com.JDBCBank.util.JDBCBankConnection;

public class UserTypesDaoImpl implements UserTypeDao {
	
	public List<UserTypes> getAllUserType(){
		List<UserTypes> utl = new ArrayList<UserTypes>();
		
		try {
			JDBCBankConnection obj = JDBCBankConnection.getinstance();
			String sql = "SELECT * FROM USER_TYPE";
			Statement stmt = obj.establishedConnection().createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				int id = rs.getInt("USER_TYPE_ID");
				String type = rs.getString("USER_TYPE");
				UserTypes newUT = new UserTypes(id, type);
				utl.add(newUT);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(IOException e1) {
			e1.printStackTrace();
		}
		return utl;
	}
	
	public UserTypes getUserType(int userTypeId) {
		PreparedStatement pstmt = null;
		UserTypes ut = null;
		
		try{
			JDBCBankConnection obj = JDBCBankConnection.getinstance();
			String sql = "SELECT * FROM USER_TYPE WHERE USER_TYPE_ID = ?";
			pstmt = obj.establishedConnection().prepareStatement(sql);
			pstmt.setInt(1, userTypeId);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("USER_TYPE_ID");
				String type = rs.getString("USER_TYPE");
				ut = new UserTypes(id, type);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}catch (IOException e1) {
			e1.printStackTrace();
		}
		
		return ut;
	}
	
	

}
