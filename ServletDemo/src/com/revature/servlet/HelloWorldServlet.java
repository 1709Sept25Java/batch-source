package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloWorldServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3526887373190996840L;
	public HelloWorldServlet() {
		super();
		// TODO Auto-generated constructor stub
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
	
		String n1 = req.getParameter("n1");
		String n2 = req.getParameter("n2");
		//String submit ="";
		
		
		PrintWriter pw = resp.getWriter();
		pw.write("<p style = \"margin:30px\">This is a success "+n1 +" " +n2+"</p>");
		pw.write("<p style = \"margin:30px\"> <a href=\"HelloWorld.html\">Go Back</a></p>");
		
	}
	

}
