package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.*;

public class AnswerServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		PrintWriter pw = resp.getWriter();
		String answer = (String) req.getAttribute("answer");
		pw.write("<p style = \"margin:30px\">The answer is: " + answer + "</p>");
		pw.write("<p style = \"margin:30px\"> <a href=\"calculator\">MORE NUMBERS PLEASE</a> </p>");
	
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter pw = resp.getWriter();
		String answer = (String) req.getAttribute("answer");
		pw.write("<p style = \"margin:30px\">The answer is: " + answer + "</p>");
		pw.write("<p style = \"margin:30px\"> <a href=\"calculator\">MORE NUMBERS PLEASE</a> </p>");
	
		
	}

}