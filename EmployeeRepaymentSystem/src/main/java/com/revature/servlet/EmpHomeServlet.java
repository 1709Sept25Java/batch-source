package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.*;

public class EmpHomeServlet extends HttpServlet{

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException{
		HttpSession session = req.getSession();
		String username = (String) session.getAttribute("username");
		
		PrintWriter pw = resp.getWriter();
		pw.println("<h1>Welcome "+username+" to Employee page</h1>");
		
		req.getRequestDispatcher("views/homepage.html").include(req, resp);
		
	}
	
}
