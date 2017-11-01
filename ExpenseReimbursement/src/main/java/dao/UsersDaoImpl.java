package dao;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.Connections;

public class UsersDaoImpl implements UsersDao {

	@Override
	public Users getUserByUsername(String username) {
		PreparedStatement pstmt = null;
		UserRolesDaoImpl utdi = new UserRolesDaoImpl();
		Users users = null;
		try {
			Connection con = Connections.getConnectionFromFile();
			String sql = "SELECT * FROM ERS_USERS WHERE U_USERNAME = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, username);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				int userId = rs.getInt("U_ID");
				// String username = rs.getString("U_USERNAME");
				String password = rs.getString("U_PASSWORD");
				String firstname = rs.getString("U_FIRSTNAME");
				String lastname = rs.getString("U_LASTNAME");
				String email = rs.getString("U_EMAIL");
				int roleId = rs.getInt("UR_ID");
				UserRoles ur = utdi.getUserRolesById(roleId);
				users = new Users(userId, username, password, firstname, lastname, email, ur);
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
		return users;
	}

	@Override
	public boolean isValidUser(String username, String password) {
		PreparedStatement pstmt = null;

		try {
			Connection con = Connections.getConnectionFromFile();
			String sql = "SELECT COUNT(U_USERNAME) FROM ERS_USERS WHERE U_USERNAME = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, username);
			ResultSet rs = pstmt.executeQuery();
			int variable = 0;
			while (rs.next()) {
				variable = rs.getInt("COUNT(U_USERNAME)");
			}
			boolean pw = true;
			if (variable == 1) {
				pw = isValidPass(username, password);
				if (pw == true) {
					return true;
				} else {
					return false;
				}
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
		return false;
	}

	public boolean isValidPass(String username, String password) {

		PreparedStatement pstmt = null;

		try {
			Connection con = Connections.getConnectionFromFile();
			String sql = "SELECT U_PASSWORD FROM ERS_USERS WHERE U_USERNAME = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, username);
			ResultSet rs = pstmt.executeQuery();
			String variable = "";
			while (rs.next()) {
				variable = rs.getString("U_PASSWORD");
			}
			if (variable.equals(password)) {
				return true;
			} else {
				return false;
			}

			
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
		return false;
	}

	@Override
	public int checkManager(String username) {
		PreparedStatement pstmt = null;
		try {
			Connection con = Connections.getConnectionFromFile();
			String sql = "SELECT UR_ID FROM ERS_USERS WHERE U_USERNAME = ?";
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, username);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				if (rs.getInt("UR_ID") == 1) {
					System.out.println("you are a manager");
					return 1;
				} else {
					System.out.println("you are an employee");
				}
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
		return 2;
	}

	@Override
	public List<Users> getAllUsers() {
		List<Users> u = new ArrayList<>();
		PreparedStatement pstmt = null;
		UserRolesDaoImpl utdi = new UserRolesDaoImpl();
		try {
			Connection con = Connections.getConnectionFromFile();
			String sql = "SELECT * FROM ERS_USERS";
			pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				int userId = rs.getInt("U_ID");
				String username = rs.getString("U_USERNAME");
				String password = rs.getString("U_PASSWORD");
				String firstname = rs.getString("U_FIRSTNAME");
				String lastname = rs.getString("U_LASTNAME");
				String email = rs.getString("U_EMAIL");
				int roleId = rs.getInt("UR_ID");
				UserRoles ur = utdi.getUserRolesById(roleId);
				u.add(new Users(userId, username, password, firstname, lastname, email, ur));
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
		return u;
	}

	@Override
	public boolean empUpdate(String username, String firstname, String lastname, String email) {
		CallableStatement cs = null;
		boolean success = false;
		try {
			Connection con = Connections.getConnectionFromFile();
			String sql = "{call EMPLOYEEUPDATE(?,?,?,?)}";
			System.out.println();
			cs = con.prepareCall(sql);
			cs.setString(1, username);
			// cs.setString(2, password);
			cs.setString(2, firstname);
			cs.setString(3, lastname);
			cs.setString(4, email);
			cs.executeQuery();
			success = true;
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
		return success;
	}

	public boolean empResetPass(String username, String password) {
		boolean result = false;
		PreparedStatement pstmt = null;
		try {
			Connection con = Connections.getConnectionFromFile();
			String sql = "UPDATE ERS_USERS SET U_PASSWORD = ? WHERE U_USERNAME = ?";
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, password);
			pstmt.setString(2, username);
			pstmt.executeQuery();
			result = true;
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
		return result;
	}

	@Override
	public Users getUserById(int userId) {
		PreparedStatement pstmt = null;
		UserRolesDaoImpl utdi = new UserRolesDaoImpl();
		Users users = null;
		try {
			Connection con = Connections.getConnectionFromFile();
			String sql = "SELECT * FROM ERS_USERS WHERE U_ID = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, userId);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				// int userId = rs.getInt("U_ID");
				String username = rs.getString("U_USERNAME");
				String password = rs.getString("U_PASSWORD");
				String firstname = rs.getString("U_FIRSTNAME");
				String lastname = rs.getString("U_LASTNAME");
				String email = rs.getString("U_EMAIL");
				int roleId = rs.getInt("UR_ID");
				UserRoles ur = utdi.getUserRolesById(roleId);
				users = new Users(userId, username, password, firstname, lastname, email, ur);
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
		return users;
	}

}
