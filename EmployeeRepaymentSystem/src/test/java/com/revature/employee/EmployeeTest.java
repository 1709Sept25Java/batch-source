package com.revature.employee;

import static org.junit.Assert.*;

import org.junit.Test;

import com.revature.dao.EmployeeDao;
import com.revature.dao.EmployeeDaoImpl;
import com.revature.domain.Employee;

public class EmployeeTest {

	@Test
	public final void loginTest() {
		String uname = "centurion";
		String pw = "roman";
		EmployeeDao eDao = new EmployeeDaoImpl();
		Employee emp = eDao.login(uname, pw);
		
		assertNotNull(emp);
		assertEquals(emp.getEmail(),"roronicus@gmail.com");
	}
	
}
