package com.revature.servlet;

import javax.servlet.http.*;

import com.revature.util.RequestHelper;

import javax.servlet.*;

import java.io.*;

public class MasterServlet extends HttpServlet {
	
	public MasterServlet() {
		super();
	}

	@Override	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("views/index.html");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String destination = RequestHelper.process(req);
		resp.sendRedirect(destination);
	}


}
