package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.revature.dao.EmployeeDao;
import com.revature.dao.EmployeeDaoImpl;
import com.revature.domain.Employee;
import com.revature.util.EmployeeAccess;

public class LoginServlet extends HttpServlet{

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException{
		
		req.getRequestDispatcher("views/login.html").forward(req, resp);
		
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException{
		HttpSession session = req.getSession();
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		//Retrieve user from the database
		EmployeeDao eDao = new EmployeeDaoImpl();
		Employee emp = eDao.login(username, password);
		
		if(emp != null) {
			//Set session attributes
			session.setAttribute("uid", emp.getId());
			session.setAttribute("username", username);
			session.setAttribute("mgr", emp.isMgr());
			
			//Redirect to Employee or Manager page
			if(emp.isMgr()) {
				resp.sendRedirect("manager");
			} else {
				resp.sendRedirect("employee");
			}
			
		} else {
			resp.sendRedirect("main");
		}
		
	}
}
