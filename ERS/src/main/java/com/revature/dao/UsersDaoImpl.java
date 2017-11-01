package com.revature.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.file.Paths;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.revature.domain.Reimbursements;
import com.revature.domain.Users;
import com.revature.util.ConnectionUtil;

public class UsersDaoImpl implements UsersDao {

	public boolean userLogin(String username, String password) {
		
			//String currentDirectory = Paths.get(".").toAbsolutePath().normalize().toString();
		
		
		try 
		{
			Connection con = ConnectionUtil.getConnectionFromFile();
				 
			PreparedStatement pstmt = null;
			String sql = "SELECT U_PASSWORD FROM ERS_USERS WHERE U_USERNAME = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, username);
			ResultSet rs = pstmt.executeQuery();

			if (rs != null) {

				while (rs.next()) {
					if (rs.getString(1).equals(password)) {
						return true;
					}
				}
			}
			con.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		} 
		return false;
	}
	
	public int getUserPrivileges(String username) 
	
	{
		//String currentDirectory = Paths.get(".").toAbsolutePath().normalize().toString();
		int result = 0;
	try 
	{
		Connection con = ConnectionUtil.getConnectionFromFile();
			 
		PreparedStatement pstmt = null;
		String sql = "SELECT UR_ID FROM ERS_USERS WHERE U_USERNAME = ?";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, username);
		ResultSet rs = pstmt.executeQuery();

		if (rs != null) {

			while (rs.next()) {
				
					return rs.getInt(1);	
			}
		}
		
		con.close();
	}
	
	catch (SQLException e) {
		e.printStackTrace();
	} catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	catch (Exception e) {
		e.printStackTrace();
	} 
	return result;

}

// Write out a prepared statment and then call it on the ManagerHomePageServlet 
	
	public List<Reimbursements> getRInfoById(int uidauthor) {
		List <Reimbursements> reimb = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		//reimb = null;
		
		
		try 
		{
			Connection con = ConnectionUtil.getConnectionFromFile();
			String sql = "SELECT * FROM ERS_REIMBURSEMENTS WHERE U_ID_AUTHOR = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, uidauthor);
			ResultSet rs = pstmt.executeQuery();
		
				while (rs.next()) {
					int amnt = rs.getInt("R_AMOUNT");
					String disc = rs.getString("R_DESCRIPTION");
					String reciept = rs.getString("R_RECEIPT");
					Date rsub = rs.getDate("R-SUBMITTED"); //u-id
					Date rres = rs.getDate("R-RESOLVED");
					int uidauth = rs.getInt("U_ID_RESOLVER"); //refernences u_id
					int rttype = rs.getInt("RT_TYPE"); //refernces rt_id
					int rtstatus = rs.getInt("RT_STATUS"); //refernces rs_id 
					reimb.add(new Reimbursements(uidauthor, amnt, uidauth, rttype, rtstatus, disc, reciept,
							rsub, rres));
					
				}
			con.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		} 
		
		return reimb;
		
	}
	

}
