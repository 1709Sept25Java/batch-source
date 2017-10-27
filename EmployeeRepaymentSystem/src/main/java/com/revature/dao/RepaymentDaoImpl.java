package com.revature.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;

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

}
