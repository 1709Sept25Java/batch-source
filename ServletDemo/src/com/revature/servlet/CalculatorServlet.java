package com.revature.servlet;

import javax.servlet.http.HttpServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.*;

public class CalculatorServlet extends HttpServlet{

	private static final long serialVersionUID = -756208604967516279L;
	
	public CalculatorServlet() {
		super();
	}
	
	@Override
	protected void doGet(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException{
		PrintWriter pw = resp.getWriter();
		pw.write("<p>The calculator page is</p> <br> <a href=\"Calculator.html\">here</a>");
	}
	

}
