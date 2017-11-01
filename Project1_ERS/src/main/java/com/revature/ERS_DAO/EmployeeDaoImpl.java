package com.revature.ERS_DAO;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.domain.Employee;
import com.revature.util.Connect;

public class EmployeeDaoImpl implements EmployeeDao {

	public EmployeeDaoImpl() {
		super();
	}

	@Override
	public List<Employee> getEmps() {
		List <Employee> emps = new ArrayList<>();
		PreparedStatement getEmps = null;
		String query = "SELECT EMPLID, FIRSTNAME, LASTNAME, EMAIL FROM EMPLOYEES ORDER BY LASTNAME ASC";
		
		try {
			Connection c = Connect.getConnection();
			getEmps = c.prepareStatement(query);
			ResultSet rs = getEmps.executeQuery();
			while(rs.next()) {
				int emplid = rs.getInt("EMPLID");
				String firstName = rs.getString("FIRSTNAME");
				String lastName = rs.getString("LASTNAME");
				String email = rs.getString("EMAIL");
				emps.add(new Employee(emplid,firstName,lastName,email));
			};
			
			c.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return emps;
		
	}
	
	

	@Override
	public Employee getEmpById(int id) {
		PreparedStatement getEmpById = null;
		Employee emp = null;
		
		try {
			Connection c = Connect.getConnection();
			getEmpById = c.prepareStatement("SELECT * FROM EMPLOYEES WHERE EMPLID = ?");
			getEmpById.setInt(1, id);
			ResultSet rs = getEmpById.executeQuery();
			while(rs.next()) {
				String firstName = rs.getString("FIRSTNAME");
				String lastName = rs.getString("LASTNAME");
				String email = rs.getString("EMAIL");
				emp = new Employee(id,firstName,lastName,email);
			}
			c.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return emp;
	}
	
	

	@Override
	public List<Employee> getEmpByFirstName(String firstName) {
		List <Employee> emps = new ArrayList<>();
		PreparedStatement p = null;

		try {
			Connection c = Connect.getConnection();
			p = c.prepareStatement("SELECT * FROM EMPLOYEES WHERE FIRSTNAME = ?");
			p.setString(1, firstName);
			ResultSet rs = p.executeQuery();
			while(rs.next()) {
				int emplid = rs.getInt("EMPLID");
				String lastName = rs.getString("LASTNAME");
				String email = rs.getString("EMAIL");
				emps.add(new Employee(emplid,firstName,lastName,email));
			}
			c.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return emps;
	}

	
	
	@Override
	public List<Employee> getEmpByLastName(String lastName) {
		PreparedStatement p = null;
		List <Employee> emps = new ArrayList<>();
		
		try {
			Connection c = Connect.getConnection();
			p = c.prepareStatement("SELECT * FROM EMPLOYEES WHERE LASTNAME = ?");
			p.setString(1, lastName);
			ResultSet rs = p.executeQuery();
			while(rs.next()) {
				int emplid = rs.getInt("EMPLID");
				String firstName = rs.getString("FIRSTNAME");
				String email = rs.getString("EMAIL");
				emps.add(new Employee(emplid,firstName,lastName,email));
			}
			c.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return emps;
	}

	
	
	@Override
	public int addEmployee(String firstName,String lastName,String email) {
		int newEmp = 0;
		String dml = "INSERT INTO EMPLOYEES(FIRSTNAME, LASTNAME, EMAIL) VALUES (?,?,?)";
		PreparedStatement p = null;
		
		
		try {
			Connection c = Connect.getConnection();
			p = c.prepareStatement(dml);
			p.setString(1, firstName);
			p.setString(2, lastName);
			p.setString(3, email);
			p.executeQuery();
			c.close();
			
		} catch (SQLException e) {
			
			/*
				Connect.getConnection().rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			*/
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return newEmp;
		
	}
	
	

}