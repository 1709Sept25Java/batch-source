package com.revature.dao;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.domain.Reimbursement;
import com.revature.main.Util;

public class ReimbursementDaoImpl {
	
	public static List<Reimbursement> getReimbursements() throws SQLException, IOException{
		List<Reimbursement> reimbursements = new ArrayList<Reimbursement>();
		Connection con = Util.getJDBCConnection();
		String sql = "SELECT * FROM REIMBURSEMENTS";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			int id = rs.getInt("RE_ID");
			int amount = rs.getInt("AMOUNT");
			String description = rs.getString("DESCRIPTION");
			//String receipt = rs.getString("RECEIPT");
			String submissionTime = rs.getString("TIME_SUBMITTED");
			String resolutionTime = rs.getString("TIME_RESOLVED");
			int author = rs.getInt("AUTHOR_ID");
			int resolver = rs.getInt("RESOLVER_ID");
			String status = rs.getString("STATUS");
			Reimbursement r = new Reimbursement(id, amount, description, null, status, submissionTime, resolutionTime,
					author, resolver);
			reimbursements.add(r);
		}
		return reimbursements;
	}
	
	public static String reimbursementsToJSON(List<Reimbursement> reimbursements) {
		String json = "{ ";
		for (Reimbursement r : reimbursements) {
			json = json + "\""+r.getReimbId()+"\" : { \"amount\" : \""+r.getAmount()+"\" , \"description\" : \""+r.getDescription()+"\" , \"timeSubmitted\" : \""+r.getTimeSubmitted()+"\" , \"timeResolved\" : \""+r.getTimeResolved()+"\" , \"author\" : \""+r.getAuthorId()+"\" , \"resolver\" : \""+r.getResolverId()+"\" , \"status\" : \""+r.getStatus()+"\" } ";
			if (r != reimbursements.get(reimbursements.size() - 1)) {
				json = json + ", ";
			}
		}
		return json + "}";
	}
	
	public static void newReimbursement(int amount, String description, int id) throws SQLException, IOException {
		Connection con = Util.getJDBCConnection();
		String time = Util.getDate();
		String sql = "{call NEW_REQUEST(?,?,?,?)}";
		CallableStatement cs = con.prepareCall(sql);
		cs.setInt(1, amount);
		cs.setString(2, description);
		cs.setString(3, time);
		cs.setInt(4, id);
		cs.execute();
	}
	
	public static void resolveReimbursement(int reimbursementId, int managerId, String status, String time) throws SQLException, IOException {
		Connection con = Util.getJDBCConnection();
		String sql = "{call RESOLVE_REQUEST(?,?,?,?)";
		CallableStatement cs = con.prepareCall(sql);
		cs.setInt(1, reimbursementId);
		cs.setString(2, time);
		cs.setInt(3, managerId);
		cs.setString(4, status);
		cs.execute();
	}
}
