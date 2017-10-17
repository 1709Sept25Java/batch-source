package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.*;

public class CalculatorServlet extends HttpServlet {

	private static final long serialVersionUID = -756208604967516279L;

	public CalculatorServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter pw = resp.getWriter();
		pw.write("<p>The calculator page is </p> <br> <a href=\"Calculator.html\">here</a>");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// obtain request parameters
		String n1 = req.getParameter("n1");
		String n2 = req.getParameter("n2");
		String operation = req.getParameter("operation");
		String answer = "";

		// calculate answer
		try {
			Double first = Double.parseDouble(n1);
			Double second = Double.parseDouble(n2);
			switch (operation) {
			case "add":
				answer = " " + (first + second);
				break;
			case "subtract":
				answer = " " + (first - second);
				break;
			case "multiply":
				answer = " " + (first * second);
				break;
			case "divide":
				answer = " " + (first / second);
				break;
			default : answer = "invalid number or operation";
			}
		} catch (Exception e) {
			answer = "invalid number or operation";
		}

		// display answer
		PrintWriter pw = resp.getWriter();
		pw.write("<p style = \"margin:30px\">The answer is: " + answer + "</p>");
		pw.write("<p style = \"margin:30px\"> <a href=\"Calculator.html\">MORE NUMBERS PLEASE</a> </p>");
	}

}