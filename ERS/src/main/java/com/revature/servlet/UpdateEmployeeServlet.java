package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.control.EmployeeRequests;
import com.revature.domain.User;

public class UpdateEmployeeServlet extends HttpServlet {

	public UpdateEmployeeServlet() {
		super();
	}

	@Override	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("views/updateEmployee.html");
		rd.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();
		int id = (int) req.getSession().getAttribute("id");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String firstName = req.getParameter("fname");
		String lastName = req.getParameter("lname");
		String email = req.getParameter("email");
//		public int updateUserById(int id, String un, String pw, String fn, String ln, String em) {

		EmployeeRequests.updateEmployee(id, username, password, firstName, lastName, email);
		resp.sendRedirect("employee");
	}
}
