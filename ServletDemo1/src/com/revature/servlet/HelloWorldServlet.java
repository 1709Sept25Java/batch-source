package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.*;

public class HelloWorldServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4217738150363355737L;

	public HelloWorldServlet() {
		super();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter pwriter = resp.getWriter();
		pwriter.write("<p>Welcome!</p>");
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String un = req.getParameter("u_name");
		String pw = req.getParameter("pw");
		
		if( un != null && pw != null) {
			PrintWriter pwriter = resp.getWriter();
			pwriter.write("<p>You have successfully logged in!</p>");
		}
	}
}
