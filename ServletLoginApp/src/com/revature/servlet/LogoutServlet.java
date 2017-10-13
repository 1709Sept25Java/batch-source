package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException{
		HttpSession session = req.getSession();
		PrintWriter pw = resp.getWriter();
		req.getRequestDispatcher("Base.html").include(req, resp);
		if(session != null) {
			session.invalidate();
		}
		pw.println("You are succussfully logged out");
		pw.println("<a href=\"Index.html\">Go Back</a>");
		//pw.println(session.getAttribute("username"));
		pw.println("</div>");
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException{
		this.doGet(req, resp);	
	}
}
