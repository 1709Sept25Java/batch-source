package com.revaturedao;

import java.io.IOException;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import com.revature.pojo.*;

import oracle.sql.BLOB;

@SuppressWarnings("deprecation")
public class ReimbursementDao {

	public Reimbursement submitReimbursement(double amount, String description, Blob reciept, Timestamp SubmitDate,
			User author, Reimbursmentype reimbType, ReimbursmentStatus reimbStatus) throws SQLException {
		Connection con = null;
		CallableStatement cs = null;
		ResultSet rs = null;
		Reimbursement reimbursement = null;
		String submitReimb = "{CALL SUBMIT_REIMB(?,?,?,?,?,?,?,?,?)}";

		try {

			con = ConnectionDB.getConnectionFromFile("/connection.properties");
			cs = con.prepareCall(submitReimb);

			SubmitDate = new Timestamp(System.currentTimeMillis());

			cs.registerOutParameter(1, java.sql.Types.NUMERIC);
			cs.registerOutParameter(2, java.sql.Types.NUMERIC);
			cs.registerOutParameter(3, java.sql.Types.NUMERIC);
			cs.setDouble(4, amount);
			cs.setString(5, description);
			cs.setBlob(6, reciept);
			cs.setTimestamp(7, SubmitDate);
			cs.setInt(8, author.getUserId());
			cs.setString(9, reimbType.getRt_type());
			cs.executeQuery();
			rs = cs.getResultSet();
			reimbStatus = new ReimbursmentStatus(null, cs.getInt(3));
			reimbursement = new Reimbursement(cs.getInt(1), amount, description, reciept, SubmitDate, null, author,
					null, reimbType, reimbStatus);

			return reimbursement;

		} catch (IOException | ClassNotFoundException e) {

			e.printStackTrace();
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (cs != null) {
				cs.close();
			}
			if (con != null) {
				con.close();
			}
		}
		return reimbursement;

	}

	public ReimbursmentStatus updateReimbStatus(User user) throws SQLException {

		Connection con = null;
		CallableStatement cs = null;
		ResultSet rs = null;
		Reimbursement reimbursement = new Reimbursement();
		ReimbursmentStatus status = new ReimbursmentStatus();
		String updateStatus = "{ CALL UPDATE_STATUS ( ? , ? , ? , ?)}";

		try {
			con = ConnectionDB.getConnectionFromFile("/connection.properties");
			cs = con.prepareCall(updateStatus);
			Timestamp resolvedTime = new Timestamp(System.currentTimeMillis());
			cs.setInt(1, status.getRt_statusId());
			cs.setString(2, status.getRs_status());
			cs.setInt(3, reimbursement.getResolverId().getUserId());
			cs.setTimestamp(4, resolvedTime);
			cs.executeUpdate();

			if (cs.executeUpdate() > 0) {

				status = new ReimbursmentStatus(cs.getString(2), cs.getInt(1));
				return status;
			}

		} catch (IOException | ClassNotFoundException e) {

			e.printStackTrace();
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (cs != null) {
				cs.close();
			}
			if (con != null) {
				con.close();
			}
		}
		return status;

	}

	public Reimbursement getReimbStatus( int authorId) throws SQLException {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ReimbursmentStatus status = null;
		Reimbursement reimbursement= null;
		Reimbursmentype type = new Reimbursmentype();
		User author = new User();
		String query = "SELECT ERS_REIMBURSEMENTS.R_ID, ERS_REIMBURSEMENTS.R_AMOUNT, ERS_REIMBURSEMENTS.R_DESCRIPTION, ERS_REIMBURSEMENTS.R_RECIEPT, ERS_REIMBURSEMENTS.R_SUBMITTED, ERS_REIMBURSEMENTS.R_RESOLVED,"
				+ " ERS_REIMBURSEMENTS.U_ID_AUTHOR, ERS_REIMBURSEMENTS.U_ID_RESOLVER, ERS_REIMBURSEMENTS.RT_TYPE, ERS_REIMBURSEMENT_STATUS.RS_ID, ERS_REIMBURSEMENT_STATUS.RS_STATUS FROM ERS_REIMBURSEMENTS FULL OUTER JOIN"
				+ " ERS_REIMBURSEMENT_STATUS ON ERS_REIMBURSEMENTS.RT_STATUS = ERS_REIMBURSEMENT_STATUS.RS_ID WHERE U_ID_AUTHOR = ?";

		try {
			con = ConnectionDB.getConnectionFromFile("/connection.properties");
			ps = con.prepareStatement(query);
			ps.setInt(1, authorId);
			rs = ps.executeQuery();

			if (rs.next()) {
				author.setUserId(rs.getInt("U_ID_AUTHOR"));
				User resolver = new User();
				resolver.setUserId(rs.getInt("U_ID_RESOLVER"));
				type.setRt_typeId(rs.getInt("RT_TYPE"));
				status = new ReimbursmentStatus(rs.getString("RS_STATUS"), rs.getInt("RS_ID"));
				reimbursement = new Reimbursement(rs.getInt("R_ID"), rs.getDouble("R_AMOUNT"),
						rs.getString("R_DESCRIPTION"), rs.getBlob("R_RECIEPT"), rs.getTimestamp("R_SUBMITTED"),
						rs.getTimestamp("R_RESOLVED"), author, resolver, type, status);

			}

		} catch (IOException | ClassNotFoundException e) {

			e.printStackTrace();
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (con != null) {
				con.close();
			}
		}
		return reimbursement;
	}

	public boolean getReimbursementById(int authorId) throws SQLException, ClassNotFoundException {

		boolean reimbExist = false;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String query = "SELECT * FROM ERS_REIMBURSEMENTS WHERE U_ID_AUTHOR = ?";
		try {
			con = ConnectionDB.getConnectionFromFile("/connection.properties");
			ps = con.prepareStatement(query);
			ps.setInt(1, authorId);
			rs = ps.executeQuery();
			if (rs.next()) {

				reimbExist = true;
			} else {

				reimbExist = false;
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {

			if (con != null) {
				con.close();
			}
		}
		return reimbExist;

	}
	
	
	public void seeAllReimbforUser(int authorId) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		Reimbursmentype type = new Reimbursmentype();
		User author = new User();
		String query = "SELECT * FROM ERS_REIMBURSEMENTS WHERE U_ID_AUTHOR = ?";
		try {
			con = ConnectionDB.getConnectionFromFile("/connection.properties");
			ps = con.prepareStatement(query);
			ps.setInt(1, authorId);
			rs = ps.executeQuery();
			ReimbursmentStatus status= null;
			Reimbursement reimbursement = null;
			if (rs.next()) {
				author.setUserId(rs.getInt("U_ID_AUTHOR"));
				User resolver = new User();
				resolver.setUserId(rs.getInt("U_ID_RESOLVER"));
				type.setRt_typeId(rs.getInt("RT_TYPE"));
				 status = new ReimbursmentStatus(rs.getString("RS_STATUS"), rs.getInt("RS_ID"));
				 reimbursement = new Reimbursement(rs.getInt("R_ID"), rs.getDouble("R_AMOUNT"),
							rs.getString("R_DESCRIPTION"), rs.getBlob("R_RECIEPT"), rs.getTimestamp("R_SUBMITTED"),
							rs.getTimestamp("R_RESOLVED"), author, resolver, type, status);

			} 
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {

			if (con != null) {
				con.close();
			}
		}
	

	}
}
