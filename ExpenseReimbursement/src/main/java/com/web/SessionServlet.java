package com.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.*;
import javax.servlet.http.*;

//@WebServlet("/SessionServlet")
public class SessionServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 899476923551160741L;

	public SessionServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (session != null) {
			response.setContentType("application/json");
			response.getWriter().write("{\"username\":\"" + session.getAttribute("username") + "\"}");
		} else {
			response.setContentType("application/json");
			response.getWriter().write("{\"username\":null}");

		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse reponse)
			throws ServletException, IOException {
		doGet(request, reponse);
	}

}
