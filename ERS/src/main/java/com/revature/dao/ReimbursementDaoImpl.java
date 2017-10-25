package com.revature.dao;

import java.io.IOException;
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
	
	public ReimbursementDaoImpl() {
		super();
	}

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
//			R_ID NUMBER NOT NULL,
//		    R_AMOUNT NUMBER(22,2) NOT NULL,
//		    R_DESCRIPTION VARCHAR2(100),
//		    R_RECEIPT BLOB,
//		    R_SUBMITTED TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
//		    R_RESOLVED TIMESTAMP,
//		    U_ID_AUTHOR NUMBER NOT NULL,
//		    U_ID_RESOLVER NUMBER,
//		    RT_TYPE NUMBER NOT NULL,
//		    RT_STATUS NUMBER NOT NULL,
			while(rs.next()){
				int rID = rs.getInt(1);
				int rAmount = rs.getInt(2);
				String rDescription = rs.getString(3);
				Blob rReceipt = rs.getBlob(4);
				Date rSubmitted = rs.getDate(5);
				Date rResolved = rs.getDate(6);
				int rAuthor = rs.getInt(7);
				int rType = rs.getInt(8);
				int rStatus = rs.getInt(9);
				
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return reimbursements;

	}
}
