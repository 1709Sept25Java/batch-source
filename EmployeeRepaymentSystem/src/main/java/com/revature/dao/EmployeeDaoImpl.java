package com.revature.dao;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.domain.Employee;
import com.revature.util.ConnectionUtil;

import oracle.jdbc.OracleTypes;

public class EmployeeDaoImpl implements EmployeeDao{

	@Override
	public Employee login(String username, String password) {
		Employee emp = null;
		
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "{call LOGIN(?,?,?)}";
			//Call to login function
			CallableStatement cs = conn.prepareCall(sql);
			//Set input strings
			cs.setString(1, username);
			cs.setString(2, password);
			//Register cursor output
			cs.registerOutParameter(3, OracleTypes.CURSOR);
			
			cs.execute();
			
			ResultSet rs =  (ResultSet)cs.getObject(3);
			
			if(rs==null) {
				return emp;
			}
			
			//Loop to retrieve User data and store in a user
			while(rs.next()) {
				//retrieve data from the resultset
				int id = rs.getInt("E_ID");
				String uname = rs.getString("USERNAME");
				String pw = rs.getString("E_PASSWORD");
				String fname = rs.getString("FNAME");
				String lname = rs.getString("LNAME");
				String email = rs.getString("EMAIL");
				String isMgr = rs.getString("IS_MANAGER");
				
				//set the boolean value for manager status
				boolean mgr = false;
				if(isMgr.equals("t")) {
					mgr = true;
				}
				
				//Create Employee
				emp = new Employee(id,uname,pw,fname,lname,email,mgr);
			}
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return emp;
	}

}
