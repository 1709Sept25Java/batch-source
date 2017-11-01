package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.revaturedao.*;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		String username = request.getParameter("username");
		System.out.println(username);
		String password = request.getParameter("password");
		System.out.println(password);
		UserBusinessLogic ubl = new UserBusinessLogic();

		try {
			if (ubl.validateUser(username, password) == true) {
				session.setAttribute("username", username);
				session.setAttribute("password", password);
				RequestDispatcher rd = request.getRequestDispatcher("HomeServlet");
				rd.forward(request, response);
				System.out.println(username);
			}
			if (ubl.adminUser(username, password) == true) {
				session.setAttribute("username", username);
				session.setAttribute("password", password);
				RequestDispatcher rd = request.getRequestDispatcher("HomeServlet");
				rd.forward(request, response);
				System.out.println("it's admin");
			}
			else {
				RequestDispatcher rd = request.getRequestDispatcher("/Login.html");
				session.setAttribute("username", null);
				rd.include(request, response);
				pw.write("Invalid username or password");
			}
		} catch (SQLException | ClassNotFoundException e) {

			e.printStackTrace();
		}

	}

}
