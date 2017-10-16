package com.revature.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.*;

public class LoginServlet extends HttpServlet{

	protected void doGet(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{
		req.getRequestDispatcher("index.html").forward(req, resp);
	}
	
	protected void doPost(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{
		HttpSession session = req.getSession();
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		if(password.isEmpty()) {
			this.doGet(req, resp);
		}
		
		session.setAttribute("username",username);
		resp.sendRedirect("profile");
		
	}
	
}
