package com.revature.dao;


import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.domain.Employee;
import com.revature.main.Util;;

public class EmployeeDaoImpl implements SystemDao {
	
	public static List<Employee> getEmployees(Connection con) throws SQLException {
		List<Employee> Employees= new ArrayList<Employee>();
		PreparedStatement ps = con.prepareStatement("SELECT * FROM EMPLOYEES");
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			int id = rs.getInt("EMP_ID");
			String user = rs.getString("EMP_USERNAME");
			String pass = rs.getString("EMP_PASSWORD");
			String first = rs.getString("FIRST_NAME");
			String last = rs.getString("LAST_NAME");
			String email = rs.getString("EMAIL");
			int managerId = rs.getInt("MANAGER_ID");
			int isManager = rs.getInt("IS_MANAGER");
			Employee e = new Employee(id, user, pass, first, last, email, managerId, isManager);
			Employees.add(e);
		}
		return Employees;
	}
	
	public static String employeesToJSON(List<Employee> employeeList) {
		//Gson gson = new Gson();
		String json = "{";
		for (Employee e : employeeList) {
			json = json + "\""+e.getEmployeeId() +"\""+":"+"{\"name\":\""+e.getEmployeeFirst()+" "+e.getEmployeeLast()+"\",\"email\":\""+e.getEmployeeEmail()+"\", \"managerId\":\""+e.getLineManager()+"\" , \"employeeId\" :\""+e.getEmployeeId()+"\"}";
			if ( e != employeeList.get(employeeList.size() - 1)) {
				json = json+",";
			}
		}
		return json+"}";
	}
	
	public static Employee getEmployee(Connection con, String username, Employee e) throws SQLException {
		String employeeQuery = "SELECT * FROM EMPLOYEES WHERE EMP_USERNAME = ?";
		PreparedStatement ps = con.prepareStatement(employeeQuery);
		ps.setString(1, username);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			int id = rs.getInt("EMP_ID");
			String user = rs.getString("EMP_USERNAME");
			String pass = rs.getString("EMP_PASSWORD");
			String first = rs.getString("FIRST_NAME");
			String last = rs.getString("LAST_NAME");
			String email = rs.getString("EMAIL");
			int managerId = rs.getInt("MANAGER_ID");
			int isManager = rs.getInt("IS_MANAGER");
			e.setEmployeeId(id);
			e.setEmployeeUsername(user);
			e.setEmployeePassword(pass);
			e.setEmployeeFirst(first);
			e.setEmployeeLast(last);
			e.setEmployeeEmail(email);
			e.setLineManager(managerId);
			e.setIsManager(isManager);
		}
		return e;
	}
	
	public static Employee getEmployee(String username, Employee e) throws SQLException, IOException {
		Connection con = Util.getJDBCConnection();
		String employeeQuery = "SELECT * FROM EMPLOYEES WHERE EMP_USERNAME = ?";
		PreparedStatement ps = con.prepareStatement(employeeQuery);
		ps.setString(1, username);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			int id = rs.getInt("EMP_ID");
			String user = rs.getString("EMP_USERNAME");
			String pass = rs.getString("EMP_PASSWORD");
			String first = rs.getString("FIRST_NAME");
			String last = rs.getString("LAST_NAME");
			String email = rs.getString("EMAIL");
			int managerId = rs.getInt("MANAGER_ID");
			int isManager = rs.getInt("IS_MANAGER");
			e.setEmployeeId(id);
			e.setEmployeeUsername(user);
			e.setEmployeePassword(pass);
			e.setEmployeeFirst(first);
			e.setEmployeeLast(last);
			e.setEmployeeEmail(email);
			e.setLineManager(managerId);
			e.setIsManager(isManager);
		}
		return e;
	}
	
	public static String getFirstName(String str) throws SQLException, IOException {
		Connection con = Util.getJDBCConnection();
		PreparedStatement ps = con.prepareStatement("SELECT FIRST_NAME FROM EMPLOYEES WHERE EMP_USERNAME = ?");
		ps.setString(1, str);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			String fname = rs.getString("FIRST_NAME");
			return fname;
		}
		return null;
	}
	
	public static String parseEmployee(Connection con, Employee emp) throws SQLException {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM EMPLOYEES WHERE EMP_USERNAME = ?");
		ps.setString(1, emp.getEmployeeUsername());
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			emp.setEmployeeId(rs.getInt("EMP_ID"));
		}
		return "";
	}
	
	public static void updateEmail(int id, String newEmail) throws SQLException, IOException {
		String sql = "{ call UPDATE_EMAIL (?,?)}";
		Connection con = Util.getJDBCConnection();
		CallableStatement cs = con.prepareCall(sql);
		cs.setInt(1, id);
		cs.setString(2, newEmail);
		cs.execute();
	}
	
	public static void updateName(int id, String newFirst, String newLast) throws SQLException, IOException {
		String sql = "{ call UPDATE_NAME (?,?,?)}";
		Connection con = Util.getJDBCConnection();
		CallableStatement cs = con.prepareCall(sql);
		cs.setInt(1, id);
		cs.setString(2, newFirst);
		cs.setString(3, newLast);
		cs.execute();
	}

}
