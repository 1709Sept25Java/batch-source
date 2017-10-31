package ers.dao;

import java.io.IOException;
import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ers.domain.Reimbursements;
import ers.util.ConnectionUtil;

public class ReimbursementsDaoImpl implements ReimbursementsDao{

	@Override
	public List<Reimbursements> getPending() {
		
		List<Reimbursements> rl = new ArrayList<>();
		Reimbursements r = new Reimbursements();
		
		try {
			ConnectionUtil obj = ConnectionUtil.getinstance();
			String sql = "SELECT * FROM ERS_REIMBURSEMENTS WHERE RT_STATUS = 1";
			Statement pstmt = obj.establishedConnection().createStatement();
			ResultSet rs = pstmt.executeQuery(sql);
			while(rs.next()) {
				UsersDao ud = new UsersDaoImpl();
				TypeDao td = new TypeDaoImpl();
				StatusDao sd= new StatusDaoImpl();
				int r_id = rs.getInt("R_ID");
				DecimalFormat df = new DecimalFormat("####0.00");
				String amount = "$" + df.format(rs.getInt("R_AMOUNT"));
				String desc = rs.getString("R_DESCRIPTION");
				Blob receipt = rs.getBlob("R_RECEIPT");
				Timestamp submit = rs.getTimestamp("R_SUBMITTED");
				Date date_submitted = new Date();
				date_submitted.setTime(submit.getTime());
				String formatDateSubmitted = new SimpleDateFormat("MM-dd-yyyy hh:mm:ss a").format(date_submitted);
				Timestamp resolved = rs.getTimestamp("R_RESOLVED");
				Date date_resolved = new Date();
				date_submitted.setTime(submit.getTime());
				String formatDateResolved = new SimpleDateFormat("MM-dd-yyyy hh:mm:ss a").format(date_resolved);
				int id_author = rs.getInt("U_ID_AUTHOR");
				String author = ud.getUsername(id_author);
				int id_resolver = rs.getInt("U_ID_RESOLVER");
				String resolver = ud.getUsername(id_resolver);
				int type = rs.getInt("RT_TYPE");
				String type1 = td.getType(type);
				int status = rs.getInt("RT_STATUS");
				String status1 =sd.getStatus(status);
				rl.add(new Reimbursements(r_id, amount, desc, 
						receipt, formatDateSubmitted, formatDateResolved, author, resolver,
						type1, status1));
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return rl;
		
	}

	@Override
	public List<Reimbursements> getResolved() {
		List<Reimbursements> rl = new ArrayList<>();
		Reimbursements r = new Reimbursements();
		
		try {
			ConnectionUtil obj = ConnectionUtil.getinstance();
			String sql = "SELECT * FROM ERS_REIMBURSEMENTS WHERE RT_STATUS = 2 OR RT_STATUS = 3";
			Statement pstmt = obj.establishedConnection().createStatement();
			ResultSet rs = pstmt.executeQuery(sql);
			while(rs.next()) {
				UsersDao ud = new UsersDaoImpl();
				TypeDao td = new TypeDaoImpl();
				StatusDao sd= new StatusDaoImpl();
				int r_id = rs.getInt("R_ID");
				DecimalFormat df = new DecimalFormat("####0.00");
				String amount = "$" + df.format(rs.getInt("R_AMOUNT"));
				String desc = rs.getString("R_DESCRIPTION");
				Blob receipt = rs.getBlob("R_RECEIPT");
				Timestamp submit = rs.getTimestamp("R_SUBMITTED");
				Date date_submitted = new Date();
				date_submitted.setTime(submit.getTime());
				String formatDateSubmitted = new SimpleDateFormat("MM-dd-yyyy hh:mm:ss a").format(date_submitted);
				Timestamp resolved = rs.getTimestamp("R_RESOLVED");
				Date date_resolved = new Date();
				date_submitted.setTime(submit.getTime());
				String formatDateResolved = new SimpleDateFormat("MM-dd-yyyy hh:mm:ss a").format(date_resolved);
				int id_author = rs.getInt("U_ID_AUTHOR");
				String author = ud.getUsername(id_author);
				int id_resolver = rs.getInt("U_ID_RESOLVER");
				String resolver = ud.getUsername(id_resolver);
				int type = rs.getInt("RT_TYPE");
				String type1 = td.getType(type);
				int status = rs.getInt("RT_STATUS");
				String status1 =sd.getStatus(status);
				rl.add(new Reimbursements(r_id, amount, desc, 
						receipt, formatDateSubmitted, formatDateResolved, author, resolver,
						type1, status1));
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return rl;
	}

	@Override
	public List<Reimbursements> getPendingByUserId(int id) {
		List<Reimbursements> rl = new ArrayList<>();
		Reimbursements r = new Reimbursements();
		
		try {
			ConnectionUtil obj = ConnectionUtil.getinstance();
			String sql = "SELECT * FROM ERS_REIMBURSEMENTS WHERE U_ID_AUTHOR = ? AND RT_STATUS = 1";
			PreparedStatement pstmt = obj.establishedConnection().prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				UsersDao ud = new UsersDaoImpl();
				TypeDao td = new TypeDaoImpl();
				StatusDao sd= new StatusDaoImpl();
				int r_id = rs.getInt("R_ID");
				DecimalFormat df = new DecimalFormat("####0.00");
				String amount = "$" + df.format(rs.getInt("R_AMOUNT"));
				String desc = rs.getString("R_DESCRIPTION");
				Blob receipt = rs.getBlob("R_RECEIPT");
				Timestamp submit = rs.getTimestamp("R_SUBMITTED");
				Date date_submitted = new Date();
				date_submitted.setTime(submit.getTime());
				String formatDateSubmitted = new SimpleDateFormat("MM-dd-yyyy hh:mm:ss a").format(date_submitted);
				Timestamp resolved = rs.getTimestamp("R_RESOLVED");
				Date date_resolved = new Date();
				date_submitted.setTime(submit.getTime());
				String formatDateResolved = new SimpleDateFormat("MM-dd-yyyy hh:mm:ss a").format(date_resolved);
				int id_author = rs.getInt("U_ID_AUTHOR");
				String author = ud.getUsername(id_author);
				int id_resolver = rs.getInt("U_ID_RESOLVER");
				String resolver = ud.getUsername(id_resolver);
				int type = rs.getInt("RT_TYPE");
				String type1 = td.getType(type);
				int status = rs.getInt("RT_STATUS");
				String status1 =sd.getStatus(status);
				rl.add(new Reimbursements(r_id, amount, desc, 
						receipt, formatDateSubmitted, formatDateResolved, author, resolver,
						type1, status1));
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return rl;
	}

	@Override
	public List<Reimbursements> getResolvedByUserId(int id) {
		List<Reimbursements> rl = new ArrayList<>();
		Reimbursements r = new Reimbursements();
		
		try {
			ConnectionUtil obj = ConnectionUtil.getinstance();
			String sql = "SELECT * FROM ERS_REIMBURSEMENTS WHERE U_ID_AUTHOR = ? AND RT_STATUS != 1";
			PreparedStatement pstmt = obj.establishedConnection().prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				UsersDao ud = new UsersDaoImpl();
				TypeDao td = new TypeDaoImpl();
				StatusDao sd= new StatusDaoImpl();
				int r_id = rs.getInt("R_ID");
				DecimalFormat df = new DecimalFormat("####0.00");
				String amount = "$" + df.format(rs.getInt("R_AMOUNT"));
				String desc = rs.getString("R_DESCRIPTION");
				Blob receipt = rs.getBlob("R_RECEIPT");
				Timestamp submit = rs.getTimestamp("R_SUBMITTED");
				Date date_submitted = new Date();
				date_submitted.setTime(submit.getTime());
				String formatDateSubmitted = new SimpleDateFormat("MM-dd-yyyy hh:mm:ss a").format(date_submitted);
				Timestamp resolved = rs.getTimestamp("R_RESOLVED");
				Date date_resolved = new Date();
				date_submitted.setTime(submit.getTime());
				String formatDateResolved = new SimpleDateFormat("MM-dd-yyyy hh:mm:ss a").format(date_resolved);
				int id_author = rs.getInt("U_ID_AUTHOR");
				String author = ud.getUsername(id_author);
				int id_resolver = rs.getInt("U_ID_RESOLVER");
				String resolver = ud.getUsername(id_resolver);
				int type = rs.getInt("RT_TYPE");
				String type1 = td.getType(type);
				int status = rs.getInt("RT_STATUS");
				String status1 =sd.getStatus(status);
				rl.add(new Reimbursements(r_id, amount, desc, 
						receipt, formatDateSubmitted, formatDateResolved, author, resolver,
						type1, status1));
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return rl;
	}

}
