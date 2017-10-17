package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloWorldServlet extends HttpServlet {

	private static final long serialVersionUID = 3526887373190996840L;
	
	public HelloWorldServlet(){
		super();
	}

	@Override
	protected void doPost(HttpServletRequest reg, HttpServletResponse resp) throws ServletException, IOException {
		String email = "";
		String password = "";
		 
		if (email == "mpimentel@mail.com" && password == "p***") {
			
			PrintWriter pw = resp.getWriter();
			pw.write("<p>You've Succesfully Loged In!  </p> <br> <a href=\"HelloWorld.html\">here</a>");
			
		} else {
			PrintWriter pw = resp.getWriter();
			pw.write("<p> Return to login and try again! </p> <br> <a href=\"HelloWorld.html\">here</a>");
		}
		
		
	
	}

}
