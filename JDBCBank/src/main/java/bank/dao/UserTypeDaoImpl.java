package bank.dao;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import bank.domain.UserType;
import bank.util.ConnectionUtil;

public class UserTypeDaoImpl implements UserTypeDao {

	public List<UserType> getAllUserType(){
		List<UserType> utl = new ArrayList<UserType>();
		
		try {
			ConnectionUtil obj = ConnectionUtil.getinstance();
			String sql = "SELECT * FROM USER_TYPE";
			Statement stmt = obj.establishedConnection().createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				int id = rs.getInt("USER_TYPE_ID");
				String type = rs.getString("USER_TYPE");
				UserType newUT = new UserType(id, type);
				utl.add(newUT);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(IOException e1) {
			e1.printStackTrace();
		}
		return utl;
	}
	
	public UserType getUserType(int userTypeId) {
		PreparedStatement pstmt = null;
		UserType ut = null;
		
		try{
			ConnectionUtil obj = ConnectionUtil.getinstance();
			String sql = "SELECT * FROM USER_TYPE WHERE USER_TYPE_ID = ?";
			pstmt = obj.establishedConnection().prepareStatement(sql);
			pstmt.setInt(1, userTypeId);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("USER_TYPE_ID");
				String type = rs.getString("USER_TYPE");
				ut = new UserType(id, type);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}catch (IOException e1) {
			e1.printStackTrace();
		}
		
		return ut;
	}
}
