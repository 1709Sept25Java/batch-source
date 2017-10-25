package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.revature.control.EmployeeRequests;
import com.revature.dao.*;
import com.revature.domain.User;


public class EmployeeServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public EmployeeServlet() {
		super();
	}

	@Override	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter pw = resp.getWriter();
		try {
			req.getRequestDispatcher("views/Employee.html").include(req,resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
		int id = (int) req.getSession().getAttribute("id");
		pw.println("Hello Employee "+ req.getSession().getAttribute("id"));
		User er = EmployeeRequests.userInfo(id);
		pw.print(er.getUsername());
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
}
