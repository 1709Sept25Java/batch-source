package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.*;

public class LogoutServlet extends HttpServlet{

	protected void doGet(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{
		HttpSession session = req.getSession();
		
		session.removeAttribute("id");
		session.removeAttribute("username");
		session.removeAttribute("mgr");
		
		req.getRequestDispatcher("views/index.html").include(req, resp);
		PrintWriter pw = resp.getWriter();
		pw.write("<p>Session attributes: "+session.getAttributeNames()+"</p>");
	}
	
}
