package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("Login.html");
		rd.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		
		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
	
		pw.println("Hello, "+username+". Welcome to your profile.");
		
		CountriesXML xml = new CountriesXML();
//		ArrayList<Country> countries = xml.readCountriesDOM();
//		pw.println(countries.size());
//		for (Country c:countries) {
//			pw.println("Something here");
//			pw.println(c.toString());
//		}
		
		int count = xml.readCountriesDOM();
		pw.println("<p> Trying to read xml countries </p>");
		
//http://localhost:8082/Week3CodeChallenge/login		
		
	}
	

}
