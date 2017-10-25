package driver;

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
	
}
