package ers.main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import ers.dao.*;
import ers.util.ConnectionUtil;

public class Driver {

	public static void main(String[] args){
		
		ConnectionUtil obj = ConnectionUtil.getinstance();
		
		try {
		System.out.println(obj.establishedConnection().getMetaData().getDriverName());
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
