package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.*;

public class LoginServlet extends HttpServlet {
	
	
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		
		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		if(password.equals("admin123")) {
			pw.println("Welcome, "+username);
			session.setAttribute("username", username);
			session.setAttribute("problem", null);
		} else {
			session.setAttribute("problem", "incorrect password");
			resp.sendRedirect("login");
		}
		
	}

}
