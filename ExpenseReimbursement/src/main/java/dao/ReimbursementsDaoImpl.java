package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import connection.Connections;

public class ReimbursementsDaoImpl implements ReimbursementsDao {

	@Override
	public boolean submitRequest(double amount, String description, Timestamp submitted, int userId, int typeId) {
		PreparedStatement pstmt = null;
		boolean result = false;
		try {
			Connection con = Connections.getConnectionFromFile();
			String sql = "INSERT INTO ERS_REIMBURSEMENTS (R_AMOUNT,R_DESCRIPTION,R_SUBMITTED,U_ID_AUTHOR,RT_TYPE) VALUES(?, ?, ?, ?, ?)";
			pstmt=con.prepareStatement(sql);
			pstmt.setDouble(1,amount);
			pstmt.setString(2, description);
			pstmt.setTimestamp(3, getCurrentTimeStamp());
			pstmt.setInt(4,userId);
			pstmt.setInt(5, typeId);
			//pstmt.setInt(6, statusId);;
			pstmt.executeUpdate();
			result=true;
		//	System.out.println("submitted request");
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public boolean approveDenyRequest(int resolverid, int status, int remid, int authorid) {
		PreparedStatement pstmt = null;
		boolean result = false;
		try{
			Connection con = Connections.getConnectionFromFile();
			String sql = "UPDATE ERS_REIMBURSEMENTS SET R_RESOLVED=CURRENT_TIMESTAMP, U_ID_RESOLVER = ?, RT_STATUS = ? WHERE R_ID = ? AND U_ID_AUTHOR = ?";

			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, resolverid);
			pstmt.setInt(2, status);
			pstmt.setInt(3, remid);
			pstmt.setInt(4, authorid);
			pstmt.executeQuery();
			result=true;
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}


	@Override
	public Timestamp getCurrentTimeStamp() {
		java.util.Date today = new java.util.Date();
		return new java.sql.Timestamp(today.getTime());
	}

	@Override
	public List<Reimbursements> viewPendingRequests(String username) {
		List<Reimbursements> rem1 = new ArrayList<>();
		//Reimbursements rem1 = null;
		UsersDaoImpl ud = new UsersDaoImpl();
		ReimbursementTypeImpl rti = new ReimbursementTypeImpl();
		ReimbursementStatusDaoImpl rsdi = new ReimbursementStatusDaoImpl();
		try{
			Connection con = Connections.getConnectionFromFile();
			String sql ="SELECT * FROM ERS_REIMBURSEMENTS"+" WHERE RT_STATUS = 22 AND U_ID_AUTHOR = "+ "(SELECT U_ID FROM ERS_USERS WHERE U_USERNAME = ?)";
			PreparedStatement pstmt=con.prepareStatement(sql);
			pstmt.setString(1, username);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int remId = rs.getInt("R_ID");
				int amount = rs.getInt("R_AMOUNT");
				String description = rs.getString("R_DESCRIPTION");
				Timestamp submitted = rs.getTimestamp("R_SUBMITTED");
				Timestamp resolved = rs.getTimestamp("R_RESOLVED");
				
				int authorid = rs.getInt("U_ID_AUTHOR");
				Users users = ud.getUserById(authorid);
				int resolverId = rs.getInt("U_ID_RESOLVER");
				Users users1 = ud.getUserById(resolverId);
				
				int type = rs.getInt("RT_TYPE");
				ReimbursementType rt=rti.getReimbursementTypeById(type);
				int status =rs.getInt("RT_STATUS");
				
				ReimbursementStatus rst = rsdi.getReimbursementStatusById(status);
				rem1.add(new Reimbursements (remId, amount, description,submitted,resolved, users, users1,rt,rst));
				
			}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rem1;
	}
//emp resolved
	@Override
	public List<Reimbursements> viewResolvedRequest(String username) {
		List<Reimbursements> rem2 = new ArrayList<>();
		PreparedStatement pstmt = null;
		UsersDaoImpl ud = new UsersDaoImpl();
		ReimbursementTypeImpl rti = new ReimbursementTypeImpl();
		ReimbursementStatusDaoImpl rsdi = new ReimbursementStatusDaoImpl();
		try{
			Connection con = Connections.getConnectionFromFile();
			String sql = "SELECT * FROM ERS_REIMBURSEMENTS WHERE RT_STATUS = 21 OR RT_STATUS = 23 AND U_ID_AUTHOR = (SELECT U_ID FROM ERS_USERS WHERE U_USERNAME = ?)";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, username);
			ResultSet rs = pstmt.executeQuery();
			//System.out.println("working");
			while(rs.next()) {
				int remId = rs.getInt("R_ID");
				int amount = rs.getInt("R_AMOUNT");
				String description = rs.getString("R_DESCRIPTION");
				Timestamp submitted = rs.getTimestamp("R_SUBMITTED");
				Timestamp resolved = rs.getTimestamp("R_RESOLVED");
				
				int authorid = rs.getInt("U_ID_AUTHOR");
				Users users = ud.getUserById(authorid);
				int resolverId = rs.getInt("U_ID_RESOLVER");
				Users users1 = ud.getUserById(resolverId);
				
				int type = rs.getInt("RT_TYPE");
				ReimbursementType rt=rti.getReimbursementTypeById(type);
				int status =rs.getInt("RT_STATUS");
				
				ReimbursementStatus rst = rsdi.getReimbursementStatusById(status);
				rem2.add(new Reimbursements (remId, amount, description,submitted,resolved, users, users1,rt,rst));
			}
			con.close();		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rem2;
	}
//manager view resolved
	@Override
	public List<Reimbursements> viewReimResolvedRequest() {
		List<Reimbursements> rem3 = new ArrayList<>();
		PreparedStatement pstmt = null;
		UsersDaoImpl ud = new UsersDaoImpl();
		ReimbursementTypeImpl rti = new ReimbursementTypeImpl();
		ReimbursementStatusDaoImpl rsdi = new ReimbursementStatusDaoImpl();
		try{
			Connection con = Connections.getConnectionFromFile();
			String sql = "SELECT * FROM ERS_REIMBURSEMENTS WHERE RT_STATUS = 21 OR RT_STATUS = 23 AND U_ID_RESOLVER IN (SELECT U_ID FROM ERS_USERS)";

			pstmt=con.prepareStatement(sql);
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int remId = rs.getInt("R_ID");
				int amount = rs.getInt("R_AMOUNT");
				String description = rs.getString("R_DESCRIPTION");
				Timestamp submitted = rs.getTimestamp("R_SUBMITTED");
				Timestamp resolved = rs.getTimestamp("R_RESOLVED");
				int authorid = rs.getInt("U_ID_AUTHOR");
				Users users = ud.getUserById(authorid);
				int resolverId = rs.getInt("U_ID_RESOLVER");
				Users users1 = ud.getUserById(resolverId);
				int type = rs.getInt("RT_TYPE");
				ReimbursementType rt=rti.getReimbursementTypeById(type);
				int status =rs.getInt("RT_STATUS");
				
				ReimbursementStatus rst = rsdi.getReimbursementStatusById(status);
				rem3.add(new Reimbursements (remId, amount, description,submitted,resolved, users, users1,rt,rst));
			}
			con.close();
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rem3;
	}
//manager
	@Override
	public List<Reimbursements> viewAllPendingRequests() {
		List<Reimbursements> rem4= new ArrayList<>();
		UsersDaoImpl ud = new UsersDaoImpl();
		ReimbursementTypeImpl rti = new ReimbursementTypeImpl();
		ReimbursementStatusDaoImpl rsdi = new ReimbursementStatusDaoImpl();
		try{
			Connection con = Connections.getConnectionFromFile();
			String sql = "SELECT * FROM ERS_REIMBURSEMENTS WHERE RT_STATUS = 22";

			PreparedStatement pstmt=con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int remId = rs.getInt("R_ID");
				int amount = rs.getInt("R_AMOUNT");
				String description = rs.getString("R_DESCRIPTION");
				Timestamp submitted = rs.getTimestamp("R_SUBMITTED");
				Timestamp resolved = rs.getTimestamp("R_RESOLVED");
				
				int authorid = rs.getInt("U_ID_AUTHOR");
				Users users = ud.getUserById(authorid);
				int resolverId = rs.getInt("U_ID_RESOLVER");
				Users users1 = ud.getUserById(resolverId);
				
				int type = rs.getInt("RT_TYPE");
				ReimbursementType rt=rti.getReimbursementTypeById(type);
				int status =rs.getInt("RT_STATUS");
				
				ReimbursementStatus rst = rsdi.getReimbursementStatusById(status);
				rem4.add(new Reimbursements (remId, amount, description,submitted,resolved, users, users1,rt,rst));
			}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rem4;
	}
	//manager view all requests from employee
	public List<Reimbursements> viewAllRequest(String firstname,String lastname) {
		List<Reimbursements> rem2 = new ArrayList<>();
		PreparedStatement pstmt = null;
		UsersDaoImpl ud = new UsersDaoImpl();
		ReimbursementTypeImpl rti = new ReimbursementTypeImpl();
		ReimbursementStatusDaoImpl rsdi = new ReimbursementStatusDaoImpl();
		try{
			Connection con = Connections.getConnectionFromFile();
			String sql = "SELECT * FROM ERS_REIMBURSEMENTS WHERE U_ID_AUTHOR = (SELECT U_ID FROM ERS_USERS WHERE U_FIRSTNAME = ? AND U_LASTNAME=?)";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, firstname);
			pstmt.setString(2, lastname);
			ResultSet rs = pstmt.executeQuery();
			//System.out.println("working");
			while(rs.next()) {
				int remId = rs.getInt("R_ID");
				int amount = rs.getInt("R_AMOUNT");
				String description = rs.getString("R_DESCRIPTION");
				Timestamp submitted = rs.getTimestamp("R_SUBMITTED");
				Timestamp resolved = rs.getTimestamp("R_RESOLVED");
				
				int authorid = rs.getInt("U_ID_AUTHOR");
				Users users = ud.getUserById(authorid);
				int resolverId = rs.getInt("U_ID_RESOLVER");
				Users users1 = ud.getUserById(resolverId);
				
				int type = rs.getInt("RT_TYPE");
				ReimbursementType rt=rti.getReimbursementTypeById(type);
				int status =rs.getInt("RT_STATUS");
				
				ReimbursementStatus rst = rsdi.getReimbursementStatusById(status);
				rem2.add(new Reimbursements (remId, amount, description,submitted,resolved, users, users1,rt,rst));
			}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rem2;
	}

}
