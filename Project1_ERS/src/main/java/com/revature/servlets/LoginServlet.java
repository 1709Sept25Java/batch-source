package com.revature.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.util.Connect;

public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 5901784448217028279L;

	public LoginServlet() {
		super();
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Boolean isValidUser = null;
		String username = (String) request.getParameter("username");
		String password = (String) request.getParameter("password");

		HttpSession session = request.getSession();

		Connection c;
		try {
			c = Connect.getConnection();
			PreparedStatement p = c.prepareStatement("SELECT * FROM EMPLOYEES WHERE USERNAME = ? AND PW = ?");
			p.setString(1, username);
			p.setString(2, password);
			ResultSet rs = p.executeQuery();
			
			if(rs.next()) {
				isValidUser = true;
				session.setAttribute("username", username);
				session.setAttribute("problem", null);
				response.sendRedirect("home");

				
				
				
			} else {
				isValidUser = false;
				System.out.println(isValidUser);
			}
			c.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
