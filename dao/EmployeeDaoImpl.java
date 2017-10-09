package com.revature.dao;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import com.revature.util.ConnectionUtil;

public class EmployeeDaoImpl implements EmployeeDao{

	@Override
	public int giveRaise(int deptId) {
		CallableStatement cs = null;
		try(Connection con = ConnectionUtil.GetConnectionFromFile()){
			String sql = "{call SP_GIVE_RAISE(?)";
			cs = con.prepareCall(sql);
			cs.setInt(1, deptId);
			cs.execute();
			return 1;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	
	
}
