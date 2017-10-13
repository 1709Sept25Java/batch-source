package revature.assignment2;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ManageConnection {

	//todo:
		//singleton, synchronized
		//get stored procedure from callable statement
		public ManageConnection(){
			super();
		}
		
		private static String filename = "connection.properties";
		private static ManageConnection instance;   
	    
	    public static synchronized ManageConnection getInstance(){
	        if(instance == null){
	            instance = new ManageConnection();
	        }
	        return instance;
	    }
	
	public static Connection getConnectionFromFile() throws IOException, SQLException{
		Properties prop = new Properties();
		InputStream in = new FileInputStream(filename);
		prop.load(in);
		String url = prop.getProperty("url");
		String username = prop.getProperty("username");
		String password = prop.getProperty("password");
		return DriverManager.getConnection(url,username,password);
	}
	
}
