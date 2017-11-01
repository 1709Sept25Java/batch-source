package com.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import connection.Connections;
import dao.Users;
import dao.UsersDao;
import dao.UsersDaoImpl;

public class Login extends HttpServlet {

	public Login() {
		super();
	}
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();
		PrintWriter pw = resp.getWriter();
		resp.setContentType("text/html");
		req.getRequestDispatcher("Login.html").include(req, resp);
		
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();
		resp.setContentType("text/html");

		PrintWriter pw = resp.getWriter();

		String username = req.getParameter("username");
		String password = req.getParameter("password");
		UsersDao ud = new UsersDaoImpl();
		
		boolean User = ud.isValidUser(username, password);
		if(User == true) {
			int man = ud.checkManager(username);
			if(man == 1) {
				session.setAttribute("username", username);
				resp.sendRedirect(req.getContextPath()+"/Manager.html");
			}else {
				session.setAttribute("username", username);
				resp.sendRedirect(req.getContextPath()+"/Employee.html");
			}
		} else{
			resp.sendRedirect(req.getContextPath()+"/Error.html");
			pw.println("<a href=\"index.html\">Go back</a>");
		}
		
		
	}
}
