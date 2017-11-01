package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.dao.LogInDaoImpl;
import com.revature.domain.Employee;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 5363702488891722177L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		HttpSession session = req.getSession(false);
		if (session == null || (Boolean)session.getAttribute("LoggedIn") != true) {
			resp.sendRedirect("Login.html");
			}
		else if ((Boolean)session.getAttribute("IsManager") == true) {
			resp.sendRedirect("ManagerHome.html");
		}
		else if ((Boolean)session.getAttribute("IsManager") == false) {
			resp.sendRedirect("EmployeeHome.html");
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		HttpSession session = req.getSession();
		String usernameInput = req.getParameter("username");
		String passwordInput = req.getParameter("password");
		PrintWriter pw = resp.getWriter();
		session.setAttribute("LoggedIn", false);
		try {
			Employee e = LogInDaoImpl.checkCredentials(usernameInput, passwordInput);
			if (e == null) {
				// same page, username not recoginzed output
				pw.write("<p>username not found</p>");
			} else if (e.getEmployeeId() == 0) {
				// same page, wrong password output
				pw.write("<p>incorrect password</p>");
			} else {
				session.setAttribute("LoggedIn", true);	
				session.setAttribute("Username", usernameInput);
				session.setAttribute("managerId", e.getEmployeeId());
				session.setAttribute("email", e.getEmployeeEmail());
				pw.write(e.getEmployeeFirst());
				if (e.getIsManager() == 1) {
					session.setAttribute("IsManager", true);
					resp.sendRedirect("ManagerHome.html");
				} else {
					session.setAttribute("IsManager", false);
					resp.sendRedirect("EmployeeHome.html");
				}
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		
	}

}
