package com.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UsersDaoImpl;

public class ResetPasswordServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();
		HttpSession session = req.getSession(false);
		UsersDaoImpl udi = new UsersDaoImpl();
		String username = (String) session.getAttribute("username");
		String password = req.getParameter("password");
		if (session != null && session.getAttribute("username") != null) {
			boolean reset = udi.empResetPass(username, password);
			
			pw.println("successfully updated information ");
		}
	}
	

}
