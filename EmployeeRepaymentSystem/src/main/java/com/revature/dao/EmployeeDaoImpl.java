package com.revature.dao;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.domain.Employee;
import com.revature.util.ConnectionUtil;

import oracle.jdbc.OracleTypes;

public class EmployeeDaoImpl implements EmployeeDao{

	//Function to retrieve user from the DB based on their login credentials
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
			
			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return emp;
	}
	
	@Override
	public Employee empInfo(int uId) {
		Employee emp = null;
		
		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "{call EMPLOYEE_INFO(?,?)}";
			CallableStatement cs = conn.prepareCall(sql);
			//Set in parameters, register out parameters
			cs.setInt(1, uId);
			cs.registerOutParameter(2, OracleTypes.CURSOR);
			
			cs.execute();
			
			ResultSet rs = (ResultSet) cs.getObject(2);
			
			//Always plan for the bad things
			if(rs == null) {
				return emp;
			}
			//Retrieve info from the ResultSet
			while(rs.next()) {
				String uname = rs.getString("USERNAME");
				String fname = rs.getString("FNAME");
				String lname = rs.getString("LNAME");
				String email = rs.getString("EMAIL");
				
				emp = new Employee(uId,uname,fname,lname,email);
			}
			
			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return emp;
	}

	@Override
	public List<Employee> getEmployees() {
		
		List<Employee> employees = new ArrayList<>();
		
		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "{call GET_EMPLOYEES(?)}";
			CallableStatement cs = conn.prepareCall(sql);
			cs.registerOutParameter(1, OracleTypes.CURSOR);
			
			cs.execute();
			
			ResultSet rs = (ResultSet) cs.getObject(1);
			
			//In case something went horribly wrong
			if(rs == null) {
				return employees;
			}
			while(rs.next()) {
				Employee emp;
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
				
				emp = new Employee(id,uname,pw,fname,lname,email,mgr);
				employees.add(emp);
			}
			
			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return employees;
	}

}
