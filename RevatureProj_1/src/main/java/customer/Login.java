package customer;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;

import driver.ManageConnection;

public class Login {
	
	public static boolean credentials(String user1,String pass1){  
		boolean status=false;  
		try{  
		Connection con=ManageConnection.getConnectionFromFile(); 
		      
		PreparedStatement ps=con.prepareStatement(  
		"Select * from ERS_USERS where U_USERNAME=? and U_PASSWORD=?");  
		ps.setString(1,user1);  
		ps.setString(2,pass1);  
		      
		ResultSet rs=ps.executeQuery();  
		status=rs.next();  		          
		}
		catch(IOException ioe)
		{
			ioe.printStackTrace();
			System.out.println("IO Exception!");
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return status;  
	}
}
