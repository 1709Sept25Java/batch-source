package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.control.EmployeeRequests;
import com.revature.domain.User;

public class BasicInfoServlet extends HttpServlet {

	public BasicInfoServlet() {
		super();
	}
	@Override	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter pw = resp.getWriter();
		pw.println("Basic Info Servlet");
		int id = (int) req.getSession().getAttribute("id");
		User employee = EmployeeRequests.userInfo(id); 
		pw.println(employee.toString() + "\n");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
