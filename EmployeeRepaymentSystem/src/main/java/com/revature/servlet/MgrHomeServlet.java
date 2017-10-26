package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class MgrHomeServlet extends HttpServlet{

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException{
		
		HttpSession session = req.getSession();
		Boolean mgr = (Boolean)session.getAttribute("mgr");
		//Check that the user is logged in
		if(session != null && session.getAttribute("uid") != null && mgr) {
			req.getRequestDispatcher("views/homepage.html").include(req, resp);
		} else {
			resp.sendRedirect("main");
		}
		
	}
	
}
