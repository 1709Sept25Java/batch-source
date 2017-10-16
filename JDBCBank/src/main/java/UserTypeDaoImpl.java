import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class UserTypeDaoImpl implements UserTypeDao {

	@Override
	public List<UserType> getUserTypes() {
		List<UserType> ut = new ArrayList<>();
		try (Connection con = Connections.getConnectionFromFile()){
			
			String sql = "SELECT * FROM USERTYPE";
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				
				int userTypeId = rs.getInt("USERTYPEID");
				String userTpye = rs.getString("USERTPYE");
				UserType newU = new UserType(userTypeId, userTpye);
				ut.add(newU);
			}
			
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return ut;
	}

	@Override
	public UserType getUserTypeById(int userTypeId) {
		
		UserType usertypes = null;
		try (Connection con = Connections.getConnectionFromFile()){
			String sql = "SELECT * FROM USERTYPE WHERE USERTYPEID = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter your user-type-id: ");
			userTypeId = sc.nextInt();
			pstmt.setInt(1, userTypeId);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				String userTpye = rs.getString("USERTPYE");
				 usertypes = new UserType(userTypeId,userTpye);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
		return usertypes;
	}

}
