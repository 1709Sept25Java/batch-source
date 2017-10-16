package revature.project2hw;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.List;

public class DeleteAccEmpty {
	
	public DeleteAccEmpty() {
		super();
	}
	
	private String user1;
	private String pw1;
	
	List<User> user;
	public String getUser1() {
		return user1;
	}

	public void setUser1(String user1) {
		this.user1 = user1;
	}

	public String getPw1() {
		return pw1;
	}

	public void setPw1(String pw1) {
		this.pw1 = pw1;
	}
	
	public void SelectAcc()
	{
	Connection con=null;
	String acc=null; 
	
	Login l=new Login();
	//replace with function that calls driver manager
		try {
			//ManageConnection lg= new ManageConnection();
			con=ManageConnection.getConnectionFromFile();
			//test insert
			
			String selectSQL = "DELETE from B_USER where "
					+ "U_USERNAME= 'testinsert2'";
			PreparedStatement preparedStatement = con.prepareStatement(selectSQL);
			ResultSet rs = preparedStatement.executeQuery(selectSQL);
			ResultSetMetaData rms = rs.getMetaData();

			while (rs.next()) {
				acc = rs.getString(1);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
