package com.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import dao.Users;
import dao.UsersDaoImpl;

public class AllEmployees extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UsersDaoImpl udi = new UsersDaoImpl();
		//managers to get all users
		List<Users> userList = udi.getAllUsers();
		resp.setContentType("application/json");
		ObjectMapper om = new ObjectMapper();
		String usersString = om.writeValueAsString(userList);
		resp.getWriter().write("{\"users\":"+usersString+"}");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
