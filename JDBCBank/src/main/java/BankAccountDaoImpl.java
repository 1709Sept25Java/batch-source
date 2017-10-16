import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class BankAccountDaoImpl implements BankAccountDao {

	@Override
	public int transaction(int bankId, int amount) {
		int amountInOut = 0;
		CallableStatement cs = null;
		try (Connection con = Connections.getConnectionFromFile()) {
			String sql = "{call TRANSACTIONS(?,?)}";
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter in bank account id");
			bankId = sc.nextInt();
			System.out.println("Enter in amount to withdrawl or deposit");
			amount = sc.nextInt();
			cs = con.prepareCall(sql);
			cs.setInt(1, bankId);
			cs.setInt(2, amount);
			cs.executeQuery();
			amountInOut = amount;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return amountInOut;
	}

	@Override
	public BankAccount getBankAccountById(int bankaccid) {
		PreparedStatement ps = null;
		UserDaoImpl udi = new UserDaoImpl();
		BankAccount bankaccount = null;
		try (Connection con = Connections.getConnectionFromFile()) {
			String sql = "SELECT * FROM BANKACCOUNT WHERE BANKACCID =?";
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter in bank account id");
			bankaccid = sc.nextInt();
			ps = con.prepareStatement(sql);
			ps.setInt(1, bankaccid);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int balance = rs.getInt("BALANCE");
				int userId = rs.getInt("USERID");
				Users u3 = udi.getUsersById(userId);
				bankaccount = new BankAccount(bankaccid, balance, u3);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return bankaccount;

	}

	@Override
	public int createBankAccount(BankAccount bankaccount) {
		int accCreated = 0;

		try (Connection con = Connections.getConnectionFromFile()) {
			con.setAutoCommit(false);
			String sql = "INSERT INTO BANKACCOUNT(BALANCE,USERID)" + "VALUES(?,?)";
			PreparedStatement pstm = con.prepareCall(sql);
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter balance");
			
			int bal = sc.nextInt();
			System.out.println("Enter user id");
			int id = sc.nextInt();
			pstm.setInt(1, bal);
			pstm.setInt(2, id);
			accCreated = pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Users userId = input.nextInt();
		return accCreated;
	}

	@Override
	public int deleteAccount(int bankaccid) {
		int bid = 0;
		CallableStatement cs = null;
		try(Connection con = Connections.getConnectionFromFile()){
			String sql = "{call DELETEACC(?)}";
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter in bankid to delete account");
			bankaccid = sc.nextInt();
			cs=con.prepareCall(sql);
			cs.setInt(1, bankaccid);
			cs.executeQuery();
			bid = bankaccid;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bid;
	}

}
