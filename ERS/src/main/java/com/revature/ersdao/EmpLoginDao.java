package com.revature.ersdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.revature.erservlets.*;

public class EmpLoginDao {

	public static boolean validate(String userName, String userPass) throws SQLException {
		boolean status = false;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {

			con = ConnectionDB.getConnectionFromFile("connection.properties");
			ps = con.prepareStatement("SELECT * FROM ERS_USERS WHERE U_USERNAME=? AND U_PASSWORD=?");
			ps.setString(1, userName);
			ps.setString(2, userPass);
			rs = ps.executeQuery();
			status = rs.next();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;

	}
}
