package com.revature.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.revature.dao.EmployeeDao;
import com.revature.dao.EmployeeDaoImpl;

public class EmpUpdateServlet extends HttpServlet{

	protected void doPost(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{
		HttpSession session = req.getSession();
		
		int eId = (Integer)session.getAttribute("uid");
		Boolean mgr = (Boolean)session.getAttribute("mgr");
		String uname = req.getParameter("username");
		String pw = req.getParameter("pw");
		String fname = req.getParameter("fname");
		String lname = req.getParameter("lname");
		String email = req.getParameter("email");
		
		EmployeeDao eDao = new EmployeeDaoImpl();
		boolean genUpdate = eDao.updateInfo(eId, uname, fname, lname, email);
		boolean pwUpdate = false;
		if(pw != null && !pw.isEmpty()) {
			pwUpdate = eDao.updatePw(eId, pw);
		}
		
		if(mgr) {
			resp.sendRedirect("manager");
		} else {
			resp.sendRedirect("employee");
		}
		
	}
	
}
