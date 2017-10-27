package customer;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import driver.ManageConnection;

public class Customerdata {
	
	public static void CustomerInfo(String user1, String pass1) {
		String cred=null;
		Boolean status=false;
		try{  
			Connection con=ManageConnection.getConnectionFromFile(); 
			      
			PreparedStatement ps=con.prepareStatement(  
			"Select * from ERS_USERS where U_USERNAME=? and U_PASSWORD=?");  
			ps.setString(1,user1);  
			ps.setString(2,pass1);  
			      
			ResultSet rs=ps.executeQuery();
			ResultSetMetaData rms= rs.getMetaData();
			rms.getCatalogName(0);
			//if gets preparedstatement successfully, then returns true
			while(rs.next())
				{
					cred=rs.getString(1);
					System.out.println(cred);
					if(cred!=null) {
						status=true;
					}
				}
			}
			catch(IOException ioe)
			{
				ioe.printStackTrace();
				System.out.println("IO Exception!");
			}
			catch(Exception e){
				e.printStackTrace();
			}
	}
	
}
