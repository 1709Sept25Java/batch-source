package com.revature.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.EmployeeDao;
import com.revature.dao.EmployeeDaoImpl;
import com.revature.domain.Employee;

public class AllEmployeesServlet extends HttpServlet{

	protected void doGet(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{
		HttpSession session = req.getSession();
		int eid = (Integer)session.getAttribute("uid");
		
		//Retrieve all employees except for the logged in manager
		EmployeeDao eDao = new EmployeeDaoImpl();
		List<Employee> emps = eDao.getEmployees(eid);
		
		//Convert Response to Json string and write to page
		ObjectMapper objmap = new ObjectMapper();
		String json = objmap.writeValueAsString(emps);
		
		resp.getWriter().write(json);
	}
	
}
