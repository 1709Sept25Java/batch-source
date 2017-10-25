package com.revature.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.EmployeeDao;
import com.revature.dao.EmployeeDaoImpl;
import com.revature.domain.Employee;

public class EmpInfoServlet extends HttpServlet{

	protected void doGet(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{
		
		HttpSession session = req.getSession();
		
		if(session != null) {
			int uId  = (Integer)session.getAttribute("uid");
			
			//Set the response to return JSON
			resp.setContentType("application/json");
			
			//Get current user data
			EmployeeDao eDao = new EmployeeDaoImpl();
			Employee emp = eDao.empInfo(uId);
			
			//Use jackson to convert to json
			ObjectMapper objmpr = new ObjectMapper();
			String jsonEmp = objmpr.writeValueAsString(emp);
			
			//write response
			resp.getWriter().write(jsonEmp);
			
		} else {
			
			resp.sendRedirect("main");
		}
		
	}
	
}
