package revature.project2hw;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class StoredProcedureTest {

	
	public void checkUser() throws SQLException {
		Connection con=null;
		String user2=null; 
		//replace with function that calls driver manager
		try {
			//ManageConnection lg= new ManageConnection();
			con=ManageConnection.getConnectionFromFile();
			
			//test insert
			String sql="{call B_USER_MATCH(?)}"; 
			CallableStatement cs =
				    con.prepareCall(sql);
			cs.setString(1, "'test'");
			//cs.registerOutParameter(1, java.sql.Types.VARCHAR);
			cs.execute();
				user2 = cs.getString(1); 	
			
			//System.out.println(user2);
			System.out.println(sql);
			
			if(user2!=null) {
				//System.out.println("Welcome back "+user+ "!!!");
				//if successfully doesn't return null does get user
				//might have this do nothing for later till pw is typed in too, 
				//but always blocks login
				//then checks for pw
			}
			else{
				System.out.println(" Did you forget your UserName?");
			}
			
			//.out.println(con.getMetaData().getDriverName());
		} catch(Exception e){
			e.printStackTrace();
		}
		//prevent leaking the connection
		con.close();
	}
	
}
