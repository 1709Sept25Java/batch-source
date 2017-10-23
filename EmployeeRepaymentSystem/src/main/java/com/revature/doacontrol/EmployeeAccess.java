package com.revature.doacontrol;

import com.revature.dao.EmployeeDao;
import com.revature.dao.EmployeeDaoImpl;
import com.revature.domain.Employee;

/*
 * Intermediary Class between the Servlet and the Dao to get access to the DB
 * */
public class EmployeeAccess {

	public static Employee getLogin(String username,String password) {
		EmployeeDao eDao = new EmployeeDaoImpl();
		Employee emp = eDao.login(username, password);
		
		return emp;
	}
	
}
