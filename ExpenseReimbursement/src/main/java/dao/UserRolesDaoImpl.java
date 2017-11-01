package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connection.Connections;

public class UserRolesDaoImpl implements UserRolesDao{

	@Override
	public UserRoles getUserRolesById(int userRoleId) {
		PreparedStatement pstmt= null;
		UserRoles userRoles = null;
		try{
			Connection con = Connections.getConnectionFromFile();
			String sql = "SELECT UR_ROLE FROM ERS_USER_ROLE WHERE UR_ID = ?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, userRoleId);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				String userRole = rs.getString("UR_ROLE");
				userRoles = new UserRoles(userRoleId,userRole);
			}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userRoles;
	}

}
