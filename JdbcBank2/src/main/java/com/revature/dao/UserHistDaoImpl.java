package com.revature.dao;

import static org.hamcrest.CoreMatchers.instanceOf;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.domain.UserHist;
import com.revature.util.ConnectionUtil;

import oracle.jdbc.internal.OracleTypes;

public class UserHistDaoImpl implements UserHistDao{

	/*
	 * Function that retrieves user history for the user with the given id from
	 * the database.
	 * 
	 * */
	@Override
	public List<UserHist> getHistory(int id) {
		
		CallableStatement cs = null;
		List<UserHist> uh = new ArrayList<>();
		
		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "{call VIEW_USER_HIST(?,?)}";
			//Prepare call to the database function VIEW_USER_HIST()
			cs = conn.prepareCall(sql);
			//Set the in parameter for the function
			cs.setInt(1, id);
			//Register the out parameter
			cs.registerOutParameter(2, OracleTypes.CURSOR);
			
			cs.execute();
			
			//Execute function call and store in a ResultSet
			ResultSet rs = (ResultSet) cs.getObject(2);
			
			//Check if the resultset is empty
			if(!rs.next()) {
				return uh;
			}
			//Reset the cursor if not emp
			rs.beforeFirst();
			
			//Loop to retrieve the USER_HIST records in the result set
			while(rs.next()) {
				//Capture the values for the records
				//int id = rs.getInt("T_ID");
				Date ld = rs.getDate("LOG_DATE");
				String type = rs.getString("LOG_TYPE");
				int account = rs.getInt("ACCOUNT_ID");
				//Store the User_hist record retrieved locally
				UserHist newUH = new UserHist(ld,type,null,account);
				uh.add(newUH);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//Return the stored UserHistory
		return uh;
	}

	/*
	 * Function to add a new record to the User_Hist table in the database when
	 * the User performs a transaction
	 * */
	@Override
	public void recordHist(int uId, int baId, String type) {
		
		CallableStatement cs =null;
		
		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "{call INSERT_USER_HIST(?,?,?)}";
			//Prepare call to database procedure INSERT_USER_HIST
			cs = conn.prepareCall(sql);
			//Set the in parameters of the function
			cs.setInt(1, uId);
			cs.setInt(2, baId);
			cs.setString(3, type);
			//Register the our parameter
			cs.registerOutParameter(4, java.sql.Types.NUMERIC);
			
			cs.executeUpdate();
			int result = cs.getInt(4);
			//Print an alert if the transaction was not recorded
			if(result == -1) {
				System.out.println("System failed to record user trnsaction.");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
