package revature.project2hw;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.Scanner;

public class SuperUser {

	public void ViewAll()
	{
	Connection con=null;
	String acc=null; 
	
	Login l=new Login();
	//replace with function that calls driver manager
		try {
			//ManageConnection lg= new ManageConnection();
			con=ManageConnection.getConnectionFromFile();
			
			//test insert
			String selectSQL = "Select * FROM B_USER";
			//+"'"+l.getUser1()+"'";
			PreparedStatement preparedStatement = con.prepareStatement(selectSQL);
			ResultSet rs = preparedStatement.executeQuery(selectSQL );
			ResultSetMetaData rms = rs.getMetaData();
			
			 ArrayList<String> columns = new ArrayList<String>();
			    for (int i = 1; i < rms.getColumnCount(); i++) {
			      String columnName = rms.getColumnName(i);
			      columns.add(columnName);
			    }
			    
			while (rs.next()) {
				for (String columnName : columns) {
			        String value = rs.getString(columnName);
			        System.out.println(columnName + " = " + value);
			      }
				
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deleteUser()
	{
	Connection con=null;
	String acc=null; 
	int uid=0;
	Scanner scan= new Scanner(System.in);
	Login l=new Login();
	//replace with function that calls driver manager
	
	System.out.println("Type in the userid associated with the account.");
	uid=scan.nextInt();
	
		try {
			String a = null;
			con=ManageConnection.getConnectionFromFile();
			
			String selectSQL = "Delete * FROM B_USER WHERE U_USERNAME="+"'"+uid+"'";
			
			PreparedStatement preparedStatement = con.prepareStatement(selectSQL);
			ResultSet rs = preparedStatement.executeQuery(selectSQL );
			ResultSetMetaData rms = rs.getMetaData();
			    
			while (rs.next()) {
				a=rs.getString(1);
			      }
				System.out.println(a);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
