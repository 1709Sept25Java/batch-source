package revature.assignment2;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Driver {

	public static void main(String[] args) throws SQLException, IOException {
		Connection con=null;
		//replace with function that calls driver manager
		try {
			ManageConnection lg= new ManageConnection();
			con=ManageConnection.getConnectionFromFile();
			
			String selectSQL = "SELECT * FROM EMPLOYEE WHERE EMPLOYEEID = 9";
			PreparedStatement preparedStatement = con.prepareStatement(selectSQL);
			//preparedStatement.setInt(1, 1);
			ResultSet rs = preparedStatement.executeQuery(selectSQL );
			while (rs.next()) {
				String firstn = rs.getString("FIRSTNAME");
				System.out.println(firstn);
			}
			
			//.out.println(con.getMetaData().getDriverName());
		} catch(Exception e){
			e.printStackTrace();
		}
		con.close();
	}

}
