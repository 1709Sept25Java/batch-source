package com.revature.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.revature.domain.Repayment;
import com.revature.util.ConnectionUtil;

import oracle.jdbc.internal.OracleTypes;
import oracle.sql.TIMESTAMP;

public class RepaymentDaoImpl implements RepaymentDao{

	@Override
	public boolean newRepayment(int eid,double amt, String summary, String file, Timestamp submit, int type) {
		boolean success = false;
		
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "{call NEW_REPAYMENT(?,?,?,?,?,?,?)}";
			CallableStatement cs = conn.prepareCall(sql);
			
			//Set up the blob
			InputStream img = new FileInputStream(file);
			
			//Set and register parameters
			cs.setDouble(1, amt);
			cs.setString(2, summary);
			cs.setBinaryStream(3, img, img.available());
			cs.setTimestamp(4, submit);
			cs.setInt(5, eid);
			cs.setInt(6, type);
			cs.registerOutParameter(7, OracleTypes.INTEGER);
			
			//Execute and check if succeeded
			cs.execute();
			int pass = cs.getInt(7);
			if(pass == 1) {
				success = true;
			}
			
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return success;
	}

	@Override
	public List<Repayment> pendingRepayments(int eid) {
		List<Repayment> pending = new ArrayList<>();
		
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "{call PENDING_REPAYMENTS(?,?)}";
			CallableStatement cs = conn.prepareCall(sql);
			//Set and Register parameters
			cs.setInt(1, eid);
			cs.registerOutParameter(2, OracleTypes.CURSOR);
			
			//Execute Procedure and get ResultSet
			cs.execute();
			ResultSet rs = (ResultSet)cs.getObject(2);
			if(rs == null) {
				return pending;
			}
			
			while(rs.next()) {
				int rid = rs.getInt("R_ID");
				double rAmt = rs.getDouble("R_AMOUNT");
				Timestamp rsubmit = rs.getTimestamp("R_SUBMITTED");
				int empid = rs.getInt("EMP_ID");
				String type = rs.getString("RT_TYPE");
				String status = rs.getString("RS_STATUS");
				
				Repayment r = new Repayment(rid,rAmt,rsubmit,empid,type,status);
				pending.add(r);
			}
			
			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return pending;
	}

	@Override
	public List<Repayment> resolvedRepayments(int eid) {
		List<Repayment> resolved = new ArrayList<>();
		
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "{call RESOLVED_REPAYMENTS(?,?)}";
			CallableStatement cs = conn.prepareCall(sql);
			//Set and Register parameters
			cs.setInt(1, eid);
			cs.registerOutParameter(2, OracleTypes.CURSOR);
			
			//Execute Procedure and get ResultSet
			cs.execute();
			ResultSet rs = (ResultSet)cs.getObject(2);
			if(rs == null) {
				return resolved;
			}
			
			while(rs.next()) {
				int rid = rs.getInt("R_ID");
				double rAmt = rs.getDouble("R_AMOUNT");
				Timestamp rsubmit = rs.getTimestamp("R_SUBMITTED");
				int empid = rs.getInt("EMP_ID");
				String type = rs.getString("RT_TYPE");
				String status = rs.getString("RS_STATUS");
				
				Repayment r = new Repayment(rid,rAmt,rsubmit,empid,type,status);
				resolved.add(r);
			}
			
			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return resolved;
	}

	@Override
	public List<Repayment> pendingForEmp(int eid) {
		List<Repayment> pending = new ArrayList<>();
		
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "{call EMP_PENDING_REQ(?,?)}";
			CallableStatement cs = conn.prepareCall(sql);
			//Set and register parameters
			cs.setInt(1, eid);
			cs.registerOutParameter(2,OracleTypes.CURSOR);
			
			//Execute Procedure and get ResultSet
			cs.execute();
			ResultSet rs = (ResultSet)cs.getObject(2);
			if(rs == null) {
				return pending;
			}
			
			while(rs.next()) {
				int id = rs.getInt("R_ID");
				double amt = rs.getDouble("R_AMOUNT");
				Timestamp submitted = rs.getTimestamp("R_SUBMITTED");
				String name = rs.getString("FNAME");
				name = name.concat(rs.getString("LNAME"));
				String type = rs.getString("RT_TYPE");
				String status = rs.getString("RS_STATUS");
				
				Repayment r = new Repayment(id,amt,submitted,name,type,status);
				pending.add(r);
			}
			
			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return pending;
	}

	@Override
	public List<Repayment> resolvedForEmp(int eid) {
		List<Repayment> resolved = new ArrayList<>();
		
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "{call EMP_RESOLVED_REQ(?,?)}";
			CallableStatement cs = conn.prepareCall(sql);
			//Set and register parameters
			cs.setInt(1, eid);
			cs.registerOutParameter(2,OracleTypes.CURSOR);
			
			//Execute Procedure and get ResultSet
			cs.execute();
			ResultSet rs = (ResultSet)cs.getObject(2);
			if(rs == null) {
				return resolved;
			}
			
			while(rs.next()) {
				int id = rs.getInt("R_ID");
				double amt = rs.getDouble("R_AMOUNT");
				Timestamp submitted = rs.getTimestamp("R_SUBMITTED");
				String name = rs.getString("FNAME");
				name = name.concat(rs.getString("LNAME"));
				String type = rs.getString("RT_TYPE");
				String status = rs.getString("RS_STATUS");
				
				Repayment r = new Repayment(id,amt,submitted,name,type,status);
				resolved.add(r);
			}
			
			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return resolved;
	}

	@Override
	public Repayment repaymentById(int rid) {
		Repayment rp = null;
		
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "{call REPAYMENT_BY_ID(?,?)}";
			CallableStatement cs = conn.prepareCall(sql);
			//Set and register parameters
			cs.setInt(1, rid);
			cs.registerOutParameter(2, OracleTypes.CURSOR);
			
			//Execute call and get ResultSet
			cs.execute();
			ResultSet rs = (ResultSet)cs.getObject(2);
			if(rs == null) {
				return rp;
			}
			
			while(rs.next()) {
				int id = rs.getInt("R_ID");
				double amt = rs.getDouble("R_AMOUNT");
				String summary = rs.getString("R_SUMMARY");
				Timestamp submitted = rs.getTimestamp("R_SUBMITTED");
				Timestamp resolved = rs.getTimestamp("R_RESOLVED");
				String eName = rs.getString("FNAME");
				eName += rs.getString("LNAME");
				String mName = rs.getString("M_FNAME");
				mName += rs.getString("M_LNAME");
				String type = rs.getString("RT_TYPE");
				String status = rs.getString("RS_STATUS");
				rp = new Repayment(id,amt,summary,submitted,resolved,eName,mName,type,status);
			}
			
			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return rp;
	}

}
