package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		PrintWriter pw = resp.getWriter();
		pw.write("<a href=\"Login.html\">Login Page</a>");
	}
	
	@Override 
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String user = req.getParameter("user");
		String pass = req.getParameter("pass");
		
		
		PrintWriter pw = resp.getWriter();
		pw.write("<p id = \"header\" style = \"background-color : lightblue;	border : 1px solid black;\">Welcome " + user + ". You have been successfully logged in.</p>");
		pw.write("<br id = \"country-header\"> <p>Here are some countries and their capitals</p>");
		pw.write("<p style = \"background-color : lightblue;	border : 1px solid black;\">Austria: Vienna<br>France: Paris<br>United Kingdom: London<br>Hungary: Budhapest<br>Germany: Berlin</p>");
	}

}
