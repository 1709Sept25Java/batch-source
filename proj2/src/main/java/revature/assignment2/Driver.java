package revature.assignment2;

import java.io.IOException;
import java.sql.SQLException;

public class Driver {

	public static void main(String[] args) throws IOException {
		
		//replace with function that calls driver manager
		try {
			con = ConnectionUtil.getConnectionFromFile();
			//.out.println(con.getMetaData().getDriverName());
		} catch(Exception e){
			e.printStackTrace();
		}
	}

}
