package com.revature.Project1_ERS;

import java.io.IOException;
//import java.sql.Date;
import java.sql.SQLException;

import com.revature.ERS_DAO.EmployeeDao;
import com.revature.ERS_DAO.EmployeeDaoImpl;
import com.revature.ERS_DAO.ReimbursementDaoImpl;
import com.revature.ERS_DAO.UserDaoImpl;
import com.revature.domain.Employee;

public class App {

	public static void main(String[] args) throws SQLException, IOException {
		
		
		/*
			try {
				Connection c = Connect.getConnection();
				System.out.println(c.isValid(0));
	
				if (c.isValid(0)) {
					c.close();
				} else {
				};
	
				System.out.println(c.isClosed());

			} catch (SQLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		*/
		
		
		//EmployeeDao e = new EmployeeDaoImpl();
		//System.out.println(e.getEmps());
		//System.out.println(e.getEmpByFirstName("Cheryl"));
		//System.out.println(e.getEmpById(6));
		//System.out.println(e.getEmpByLastName("Franklin"));
		//int vp = e.addEmployee("Vanessa","Perrier","vperrier@company.com");
		//System.out.println(e.addEmployee("Vanessa","Perrier","vperrier@company.com")); 
		
		/*
		ReimbursementDaoImpl r = new ReimbursementDaoImpl();
		System.out.println(r.getRmbs());
		*/
		
		
		UserDaoImpl udi = new UserDaoImpl();
		udi.verifyUser("hot2trot86", "paymebackNOW!");
		
		
		
		
	}	
}