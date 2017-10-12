import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Driver {

	
	public static void main(String[] args) {
		
		Connection con = null;
		
		try {
			
			con = Connections.getConnectionFromFile();
			System.out.println(con.getMetaData().getDriverName());
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
