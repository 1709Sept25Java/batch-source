package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.*;

public class HelloWorldServlet extends HttpServlet{

	public HelloWorldServlet() {
		super();
	}

	private static final long serialVersionUID = -4217738150363355737L;
	
	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException{
		//Obtain the username and password from the form
		String username = req.getParameter("username");
		String pw = req.getParameter("pw");
		
		PrintWriter pwrite = resp.getWriter();
		pwrite.write("<h1>Login Info Submitted!</h1><p>Thanks for logging in: "+username+"</p>");
	}
	
}
