package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import javax.xml.*;
import org.xml.sax.*;
import org.w3c.dom.*;

public class LoginServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		PrintWriter pw = resp.getWriter();
		resp.setContentType("text/html");
		req.getRequestDispatcher("Login.html").include(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		
		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		if(password.equals("password")) {
			pw.println("<h style=\"font-size: 16px\">Welcome, "+ username + "!</h>");
			pw.println("<br>");
			pw.println("<br>");
			pw.println("<h><b>The Capital of 5 Countries</b></h>");
			pw.println("<p>Capital of Vietnam - Hanoi</p>");
			pw.println("<p>Capital of United States - Washington D.C</p>");
			pw.println("<p>Capital of China - Beijing</p>");
			pw.println("<p>Capital of Japan - Tokyo</p>");
			pw.println("<p>Capital of France - Paris</p>");
			pw.println("<p><a href=\"index.html\">Go back</a></p>");
			session.setAttribute("username", username);
			session.setAttribute("problem", null);
		} else {
			session.setAttribute("problem", "incorrect password");
			resp.sendRedirect("login");
		}
		
	}

}
