package com.revature.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import com.revature.domain.*;
import com.revature.util.ConnectionUtil;
import java.util.Date;

import oracle.jdbc.OracleTypes;

public class ReimbursementDaoImpl implements ReimbursementDao {

	@Override
	public List<Reimbursement> getReimbursements() {
		List<Reimbursement> reimbursements = new ArrayList<>();
		String sql = "{call VIEW_REIMBURSEMENTS(?)}";
		CallableStatement pstmt;
		try(Connection con = ConnectionUtil.getConnectionFromFile()) {
			pstmt = con.prepareCall(sql);
			pstmt.registerOutParameter(1, OracleTypes.CURSOR);
			pstmt.executeUpdate();
			ResultSet rs = (ResultSet) pstmt.getObject(1);
			while(rs.next()){
				int rID = rs.getInt(1);
				int amt = rs.getInt(2);
				Date submitted = rs.getDate(3); 
				int uIDAuthor = rs.getInt(4);
				int rType = rs.getInt(5);
				int rStatus = rs.getInt(6);
				Reimbursement reimbursement = new Reimbursement(rID,amt,submitted, uIDAuthor, rType, rStatus);
				reimbursements.add(reimbursement);
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return reimbursements;
	}

	//Simple Query returns Reimbursement fields, allows us to create reimbursement object
	//Blob not in reimbursements
	@Override
	public List<Reimbursement> getReimbursementsById(int id) {
		List<Reimbursement> reimbursements = new ArrayList<>();
		String sql = "{call USER_REIMBURSEMENTS(?,?)}";
		CallableStatement pstmt;
		try(Connection con = ConnectionUtil.getConnectionFromFile()) {
			pstmt = con.prepareCall(sql);
			pstmt.setInt(1,id);
			pstmt.registerOutParameter(2, OracleTypes.CURSOR);
			pstmt.executeUpdate();
			ResultSet rs = (ResultSet) pstmt.getObject(2);
			while(rs.next()){
				int rID = rs.getInt(1);
				int rAmount = rs.getInt(2);
				String rDescription = rs.getString(3);
				//Blob rReceipt = rs.getBlob(4);
				Date rSubmitted = rs.getDate(5);
				Date rResolved = rs.getDate(6);
				int rAuthor = rs.getInt(7);
				int rResolver = rs.getInt(8);
				int rType = rs.getInt(9);
				int rStatus = rs.getInt(10);
				Reimbursement reimbursement = new Reimbursement(rID, rAmount, rDescription, rSubmitted, rResolved, rAuthor, rResolver, rType, rStatus); 
				reimbursements.add(reimbursement);
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return reimbursements;

	}
	
	@Override
	public List<Reimbursement> getReimbursementsByStatus(int status) {
		List<Reimbursement> reimbursements = new ArrayList<>();
		String sql = "{call STATUS_REIMBURSEMENTS(?,?)}";
		CallableStatement pstmt;
		try(Connection con = ConnectionUtil.getConnectionFromFile()) {
			pstmt = con.prepareCall(sql);
			pstmt.setInt(1, status);
			pstmt.registerOutParameter(2, OracleTypes.CURSOR);
			pstmt.executeUpdate();
			ResultSet rs = (ResultSet) pstmt.getObject(2);
			while(rs.next()){
				int rID = rs.getInt(1);
				int rAmount = rs.getInt(2);
				String rDescription = rs.getString(3);
				//Blob rReceipt = rs.getBlob(4);
				Date rSubmitted = rs.getDate(5);
				Date rResolved = rs.getDate(6);
				int rAuthor = rs.getInt(7);
				int rResolver = rs.getInt(8);
				int rType = rs.getInt(9);
				int rStatus = rs.getInt(10);
				InputStream in = null;
				int length = 0;
				Reimbursement reimbursement = new Reimbursement(rID, rAmount, rDescription, in, length, rSubmitted, rResolved, rAuthor, rResolver, rType, rStatus); 
				reimbursements.add(reimbursement);
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return reimbursements;
	}
	

	@Override
	public int createReimbursement(int amount, String description, int author, String type) {
		String sql = "{call SUBMIT_REIMBURSEMENT(?,?,?,?,?)}";
		CallableStatement pstmt;
		int success = 0;
		try(Connection con = ConnectionUtil.getConnectionFromFile()) {
			pstmt = con.prepareCall(sql);
			pstmt.setInt(1,amount);
			pstmt.setString(2, description);
			pstmt.setInt(3, author);
			ReimbursementTypeDao rtd = new ReimbursementTypeDaoImpl();
			int existingType = rtd.getReimbursementTypeByName(type);
			pstmt.setInt(4, existingType);
			pstmt.registerOutParameter(5, OracleTypes.NUMBER);
			pstmt.executeUpdate();
			ResultSet rs = (ResultSet) pstmt.getObject(5);
			while(rs.next()){
				success = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return success;
	}

	@Override
	public void updateReimbursement(int rID, int mID, int status) {
		String sql = "{call REVIEW_REIMBURSEMENT(?,?,?)}";
		CallableStatement pstmt;
		try(Connection con = ConnectionUtil.getConnectionFromFile()) {
			pstmt = con.prepareCall(sql);
			pstmt.setInt(1,rID);
			pstmt.setInt(2, mID);
			pstmt.setInt(3, status);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Reimbursement> getResolvedReimbursements() {
		List<Reimbursement> reimbursements = new ArrayList<>();
		String sql = "{call RESOLVED_REIMBURSEMENTS(?)}";
		CallableStatement pstmt;
		try(Connection con = ConnectionUtil.getConnectionFromFile()) {
			pstmt = con.prepareCall(sql);
			pstmt.registerOutParameter(1, OracleTypes.CURSOR);
			pstmt.executeUpdate();
			ResultSet rs = (ResultSet) pstmt.getObject(1);
			while(rs.next()){
				int rID = rs.getInt(1);
				int amt = rs.getInt(2);
				String description = rs.getString(3);
				Date submitted = rs.getDate(4); 
				Date resolved = rs.getDate(5); 
				int uIDAuthor = rs.getInt(6);
				int uIDResolver = rs.getInt(7);
				int rType = rs.getInt(8);
				int rStatus = rs.getInt(9);
				Reimbursement reimbursement = new Reimbursement(rID,amt, description, submitted, resolved, uIDAuthor, uIDResolver, rType, rStatus);
				reimbursements.add(reimbursement);
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return reimbursements;
	}
}
