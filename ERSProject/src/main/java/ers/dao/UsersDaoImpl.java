package ers.dao;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import oracle.jdbc.driver.OracleDriver;

import ers.util.ConnectionUtil;

public class UsersDaoImpl implements UsersDao {

	@Override
	public int getUserRoleId(String username, String password) {
		
		PreparedStatement pstmt = null;
		int id = 0;
		
		try {
			//Class.forName("oracle.jdbc.driver.OracleDriver");
			ConnectionUtil obj = ConnectionUtil.getinstance();
			String sql = "SELECT UR_ID FROM ERS_USERS "
					+ "WHERE U_USERNAME = ? AND U_PASSWORD = ?";
			pstmt = obj.establishedConnection().prepareStatement(sql);
			pstmt.setString(1, username.toUpperCase());
			pstmt.setString(2, password.toUpperCase());
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				id = rs.getInt("UR_ID");
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}catch (IOException e1) {
			e1.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return id;
	}

}
