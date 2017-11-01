package com.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.fasterxml.jackson.databind.ObjectMapper;

import dao.Users;
import dao.UsersDaoImpl;

public class UserServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UsersDaoImpl udi = new UsersDaoImpl();
		//managers to get all users
		List<Users> userList = udi.getAllUsers();
		resp.setContentType("application/json");
		ObjectMapper om = new ObjectMapper();
		String usersString = om.writeValueAsString(userList);
		resp.getWriter().write("{\"users\":"+usersString+"}");
		
		//employee to view their own information
		String username = req.getParameter("username");
		Users users = udi.getUserByUsername(username);
		String userString = om.writeValueAsString(users);
		resp.getWriter().write("{\"username\":" + userString);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//employees can update information
		UsersDaoImpl udi = new UsersDaoImpl();
		String username = req.getParameter("username");
		//String password = req.getParameter("password");
		String firstname = req.getParameter("firstname");
		String lastname = req.getParameter("lastname");
		String email = req.getParameter("email");
		boolean empupdate = udi.empUpdate(username, firstname, lastname, email);
		
		//employee changing password
		//String username = req.getParameter("username");
		String password = req.getParameter("password");
		boolean reset = udi.empResetPass(username, password);
		
	}

}
