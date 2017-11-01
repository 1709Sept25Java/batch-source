package com.revaturedao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.revature.pojo.*;

public class UserDao {


	public User getUserByUserId(int userId) throws SQLException, ClassNotFoundException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		User user = new User();
		UserRoles userRole = new UserRoles();

		String query = "SELECT U_ID, U_USERNAME, U_FIRSTNAME, U_LASTNAME, U_EMAIL, UR_ID "
				+ "FROM ERS_USERS WHERE U_ID = ?";

		try {
			con = ConnectionDB.getConnectionFromFile("/connection.properties");
			ps = con.prepareStatement(query);
			ps.setLong(1, userId);
			rs = ps.executeQuery();

			if (rs.next()) {

				user.setUserId(rs.getInt("U_ID"));
				user.setUserName(rs.getString("U_USERNAME"));
				user.setFirstName(rs.getString("U_FIRSTNAME"));
				user.setLastName(rs.getString("U_LASTNAME"));
				user.setEmail(rs.getString("U_EMAIL"));
				userRole.setRoleId(rs.getInt("UR_ID"));

				return user;
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (con != null) {
				con.close();
			}
		}
		return null;
	}

	public User getUserByUserNamePassword(String username, String password)
			throws SQLException, ClassNotFoundException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		User user = null;
		UserRoles role = null;

		String query = "SELECT ERS_USERS.U_ID, ERS_USERS.U_USERNAME, ERS_USERS.U_FIRSTNAME, ERS_USERS.U_LASTNAME,"
				+ "ERS_USERS.U_EMAIL, ERS_USERS.UR_ID, ERS_USERS_ROLES.UR_ROLE FROM ERS_USERS "
				+ "FULL OUTER JOIN ERS_USERS_ROLES ON ERS_USERS.UR_ID =ERS_USERS_ROLES.UR_ID "
				+ "WHERE U_USERNAME = ? AND U_PASSWORD= ?";

		try {
			con = ConnectionDB.getConnectionFromFile("/connection.properties");
			ps = con.prepareStatement(query);
			ps.setString(1, username);
			ps.setString(2, password);
			rs = ps.executeQuery();
			if (rs.next()) {

				role = new UserRoles(rs.getInt("UR_ID"), rs.getString("UR_ROLE"));
				user = new User(rs.getInt("U_ID"), rs.getString("U_USERNAME"), rs.getString("U_FIRSTNAME"),
						rs.getString("U_LASTNAME"), rs.getString("U_EMAIL"), role);
				return user;
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (con != null) {
				con.close();
			}
		}
		return user;
	}

	public String getUserPassword(String username) throws SQLException, ClassNotFoundException {
		Connection con = null;
		String password = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String query = "SELECT U_PASSWORD FROM ERS_USERS WHERE U_USERNAME = ?";

		try {
			con = ConnectionDB.getConnectionFromFile("/connection.properties");
			ps = con.prepareStatement(query);
			ps.setString(1, username);
			rs = ps.executeQuery();
			if (rs.next()) {
				password = rs.getString("U_PASSWORD");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {

			if (con != null) {
				con.close();
			}
		}
		return password;

	}

	public boolean getUserbyUsername(String username) throws SQLException, ClassNotFoundException {

		boolean userExist = false;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String query = "SELECT * FROM ERS_USERS WHERE U_USERNAME = ?";
		try {
			con = ConnectionDB.getConnectionFromFile("/connection.properties");
			ps = con.prepareStatement(query);
			ps.setString(1, username);
			rs = ps.executeQuery();
			if (rs.next()) {

				userExist = true;
			} else {

				userExist = false;
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {

			if (con != null) {
				con.close();
			}
		}
		return userExist;

	}
	public ArrayList<User> getEmployee() throws SQLException, ClassNotFoundException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<User> userArrayList = new ArrayList<User>();
		UserRoles userRole = null;
		String query = "SELECT * FROM ERS_USERS";

		try {
			con = ConnectionDB.getConnectionFromFile("/connection.properties");
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();

			while (rs.next()) {
				System.out.println("this is good");
				int userId = rs.getInt("U_ID");
				String username = rs.getString("U_USERNAME");
				String firstName = rs.getString("U_FIRSTNAME");
				String lastName = rs.getString("U_LASTNAME");
				String email = rs.getString("U_EMAIL");
				System.out.println("ok");
				userRole = new UserRoles(rs.getInt("UR_ID"), null);
				System.out.println("ok too");
				User user = new User(userId, username, firstName, lastName, email, userRole);
				System.out.println("where is the issue");
				userArrayList.add(user);
				System.out.println(userArrayList.toString());
			}

		} catch (IOException e) {

			e.printStackTrace();
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (con != null) {
				con.close();
			}
		}
		return userArrayList;

	}
}
