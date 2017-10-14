package revature.project2hw;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Properties;

public class ManageConnection {

		public ManageConnection(){
			super();
		}
		
		private static String filename = "connection.properties";
		private static ManageConnection instance;   
	    
		//singleton, synchronized
	    public static synchronized ManageConnection getInstance(){
	        if(instance == null){
	            instance = new ManageConnection();
	        }
	        return instance;
	    }
	
	    //creates a connection, with drivermanager, 
	    //using a connectionstring with arguements from connection.properties file with inputstream
	public static Connection getConnectionFromFile() throws IOException, SQLException{
		Properties prop = new Properties();
		InputStream in = new FileInputStream(filename);
		prop.load(in);
		String url = prop.getProperty("url");
		String username = prop.getProperty("username");
		String password = prop.getProperty("password");
		return DriverManager.getConnection(url,username,password);
	}
	
	/*
	public void fillUserTable() throws SQLException, IOException{
		//testing connection with hardcode, won't be implemented
		String driver_db="jdbc:oracle:thin:";
		String hostname_db="@sept25java.c1tpw2p9yz97.us-east-2.rds.amazonaws.com:1521:ORCL";
		String user_db="Admin";
		String pass_db="testing123";
		String test="Select FIRSTNAME from EMPLOYEE where EMPLOYEEID=0";
		
		Connection dbcon = null;

			try {	
			dbcon=DriverManager.getConnection(driver_db+ hostname_db, user_db, pass_db);
			PreparedStatement ps= dbcon.prepareStatement(test);
			ResultSet rs= ps.executeQuery();
			ResultSetMetaData rsm=rs.getMetaData();
			
			//close connection
			System.out.println();
			dbcon.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
	}
	*/
	
}
