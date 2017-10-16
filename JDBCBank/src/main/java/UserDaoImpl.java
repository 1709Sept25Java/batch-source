import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserDaoImpl implements UserDao {

	@Override
	public Users login(String u, String p) {
		Users users = null;
		UserTypeDaoImpl utdl = new UserTypeDaoImpl();
		try (Connection con = Connections.getConnectionFromFile()) {

			Scanner input = new Scanner(System.in);
			String sql = "SELECT * FROM USERS WHERE USERNAME=? AND PASSWORD =?";

			PreparedStatement pstm = con.prepareStatement(sql);
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter username: ");
			u = sc.nextLine();
			pstm.setString(1, u);
			System.out.println("Enter password: ");
			p = sc.nextLine();
			pstm.setString(2, p);
			ResultSet rs = pstm.executeQuery();

			while (rs.next()) {
				int userID = rs.getInt("USERID");
				String username = rs.getString("USERNAME");
				String password = rs.getString("PASSWORD");
				int usertypeid = rs.getInt("USERTYPEID");
				UserType userType = utdl.getUserTypeById(usertypeid);
				users = new Users(userID, username, password, userType);
				if (u.equals(username) && p.equals(password)) {
					System.out.println("username and password exist");
				} else {
					System.out.println("try again");
				}
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return users;
	}

	@Override
	public int createAccount(Users users) {
		int usersCreated = 0;
		Connection con = null;

		try {
			Scanner input = new Scanner(System.in);
			System.out.println("create an account ");
			System.out.println("Enter username: ");
			String u = users.getUsername();
			String username = input.nextLine();
			System.out.println("Enter password: ");
			String password = input.nextLine();
			System.out.println("Enter user access type: ");
			int access = input.nextInt();

			con = Connections.getConnectionFromFile();
			con.setAutoCommit(false);
			String sql = "INSERT INTO USERS (USERNAME,PASSWORD,USERTYPEID)" + "VALUES(?,?,?)";
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setString(1, username);
			pstm.setString(2, password);
			pstm.setInt(3, access);
			usersCreated = pstm.executeUpdate();
			con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return usersCreated;
	}

	@Override
	public List<Users> getUsers() {
		List<Users> u1 = new ArrayList<>();
		UserTypeDaoImpl utdl = new UserTypeDaoImpl();
		try {
			Connection con = Connections.getConnectionFromFile();
			String sql = "SELECT * FROM USERS";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				int userID = rs.getInt("USERID");
				String username = rs.getString("USERNAME");
				String password = rs.getString("PASSWORD");
				int usertypeid = rs.getInt("USERTYPEID");
				UserType userTyper = utdl.getUserTypeById(usertypeid);
				u1.add(new Users(userID, username, password, userTyper));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return u1;
	}

	@Override
	public Users getUsersById(int userId) {
		Users user = null;
		PreparedStatement ps = null;
		UserTypeDaoImpl utdl = new UserTypeDaoImpl();
		try (Connection con = Connections.getConnectionFromFile()) {
			String sql = "SElECT * FROM USERS WHERE USERID=?";
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter in your user id");
			userId = sc.nextInt();
			ps = con.prepareStatement(sql);
			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String username = rs.getString("USERNAME");
				String password = rs.getString("PASSWORD");
				int usertypeid = rs.getInt("USERTYPEID");
				UserType userTyper = utdl.getUserTypeById(usertypeid);
				user = new Users(userId, username, password, userTyper);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public String adminCreate(String user, String pass, int typeid) {
		String result = "success";
		CallableStatement cs = null;
		try (Connection con = Connections.getConnectionFromFile()) {
			String sql = "{CALL ADMINCREATE(?,?,?)}";
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter username");
			user = sc.nextLine();
			System.out.println("Enter password");
			pass = sc.nextLine();
			System.out.println("Enter usertype id");
			typeid = sc.nextInt();
			cs = con.prepareCall(sql);
			cs.setString(1, user);
			cs.setString(2, pass);
			cs.setInt(3, typeid);
			cs.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public String adminUpdate(int userid, String users, String pass, int typeid) {
		String result = "success";
		CallableStatement cs = null;
		try (Connection con = Connections.getConnectionFromFile()) {
			String sql = "{CALL ADMINUPDATE(?,?,?,?)}";

			Scanner sc = new Scanner(System.in);
			System.out.println("Enter userid that you want to update");
			userid = sc.nextInt();
			System.out.println("Enter username to update");
			users = sc.nextLine();
			users = sc.nextLine();
			System.out.println("Enter password to update");
			pass = sc.nextLine();
			System.out.println("Enter user type id to update ");
			typeid = sc.nextInt();

			cs = con.prepareCall(sql);
			cs.setInt(1, userid);
			cs.setString(2, users);
			cs.setString(3, pass);
			cs.setInt(4, typeid);

			cs.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public String adminDelete(int userid) {
		String result = "success";
		CallableStatement cs = null;
		try (Connection con = Connections.getConnectionFromFile()) {
			String sql = "{call ADMINDELETE(?)}";
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter userid to delete");
			userid = sc.nextInt();
			cs = con.prepareCall(sql);
			cs.setInt(1, userid);
			cs.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

}
