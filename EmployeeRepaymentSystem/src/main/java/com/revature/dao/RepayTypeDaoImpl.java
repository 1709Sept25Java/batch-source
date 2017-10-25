package com.revature.dao;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.domain.RepayType;
import com.revature.util.ConnectionUtil;

import oracle.jdbc.internal.OracleTypes;

public class RepayTypeDaoImpl implements RepayTypeDao{

	@Override
	public List<RepayType> getTypes() {
		List<RepayType> types = new ArrayList<>();
		
		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "{call GET_TYPES(?)}";
			CallableStatement cs = conn.prepareCall(sql);
			cs.registerOutParameter(1, OracleTypes.CURSOR);
			
			cs.execute();
			
			ResultSet rs = (ResultSet) cs.getObject(1);
			
			//In case something went terribly wrong
			if(rs == null) {
				return types;
			}
			while(rs.next()) {
				int id = rs.getInt("RT_ID");
				String type = rs.getString("RT_TYPE");
				
				RepayType rt = new RepayType(id,type);
				types.add(rt);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return types;
	}

}
