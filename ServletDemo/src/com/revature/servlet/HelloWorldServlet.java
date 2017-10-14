package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.*;

public class HelloWorldServlet extends HttpServlet {
	private static final long serialVersionUID = -756208604967516279L;
	
	public HelloWorldServlet() {
		super();
	}
	
	@Override 
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter pw = resp.getWriter();
		pw.write("<p>The hello world page is </p> <br> <a href=\"HelloWorld.html\">here</a>");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String un = req.getParameter("username");
		String pk = req.getParameter("password");
		PrintWriter pw = resp.getWriter();
		pw.write("<p>Welcome!<br>You are logged in as: <em>"+un+"</em></p>");
	}
}
