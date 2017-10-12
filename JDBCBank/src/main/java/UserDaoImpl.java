import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UserDaoImpl implements UserDao {

	public Users login(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	public int createAccount(Users users) {
		int usersCreated = 0;
		Connection con = null;
		
		try {
			Scanner input = new Scanner(System.in);
			System.out.println("Enter username: ");
			String username = input.nextLine();
			System.out.println("Enter password: ");
			String password = input.nextLine();
			
			con = Connections.getConnectionFromFile();
			con.setAutoCommit(false);
			String sql = "INSERT INTO USERS (USERNAME,PASSWORD)" + "VALUES(?,?)";
			PreparedStatement pstm = con.prepareCall(sql);			
			pstm.setString(1, username);
			pstm.setString(2, password);
			usersCreated = pstm.executeUpdate();
			con.commit();
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
		if (con != null){
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return usersCreated;
	}
	
	public int deposit(int bankId, int amount) {
		Scanner sc = new Scanner(System.in);
		int amountd = sc.nextInt();
		CallableStatement cs = null;
		try{
			Connection con = Connections.getConnectionFromFile();
			String sql = "{call DEPOSIT(?,?)}";
			cs.getConnection().prepareCall(sql);
			cs.setInt(1, bankId);
			cs.setInt(2, amount);
			cs.execute();
			amountd=amount;
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
		return amountd;
	}

	public int overdraft(int bankId, int amount) {
		// TODO Auto-generated method stub
		return 0;
	}

	
}
