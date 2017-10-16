package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.*;

public class HelloWorldServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	public HelloWorldServlet() {
		super();
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		
		PrintWriter pw = resp.getWriter();
		pw.write("<p>The login was successfull</p> <br> <a href=\"HelloWorld.html\">Click here</a>");

}
}
