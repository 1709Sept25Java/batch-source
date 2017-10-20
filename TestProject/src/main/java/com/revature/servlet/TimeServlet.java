package com.revature.servlet;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.http.*;

public class TimeServlet extends HttpServlet {

	public TimeServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");
		LocalDateTime now = LocalDateTime.now();
		resp.getWriter().write("{\"hour\" : " + now.getHour() + ",\"minute\" : " + now.getMinute() + ",\"second\" : "
				+ now.getSecond()+"}");
	}

}