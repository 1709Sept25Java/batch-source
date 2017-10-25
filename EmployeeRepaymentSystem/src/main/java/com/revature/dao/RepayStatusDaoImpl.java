package com.revature.dao;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.domain.RepayStatus;
import com.revature.util.ConnectionUtil;

import oracle.jdbc.OracleTypes;

public class RepayStatusDaoImpl implements RepayStatusDao{

	@Override
	public List<RepayStatus> getStatuses() {
		List<RepayStatus> stats = new ArrayList<>();
		
		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "{call GET_STATUSES(?)}";
			CallableStatement cs = conn.prepareCall(sql);
			//Register out parameter
			cs.registerOutParameter(1, OracleTypes.CURSOR);
			
			cs.execute();
			ResultSet rs = (ResultSet) cs.getObject(1);
			
			if(rs == null) {
				return stats;
			}
			while(rs.next()) {
				int id = rs.getInt("RS_ID");
				String name = rs.getString("RS_STATUS");
				
				RepayStatus status = new RepayStatus(id,name);
				stats.add(status);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return stats;
	}

}
