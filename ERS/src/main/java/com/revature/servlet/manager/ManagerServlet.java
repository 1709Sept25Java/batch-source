package com.revature.servlet.manager;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.revature.control.ManagerRequests;
import com.revature.domain.User;

public class ManagerServlet extends HttpServlet {

	public ManagerServlet() {
		super();
	}
	
	@Override	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = (int) req.getSession().getAttribute("id");
		User manager = ManagerRequests.userInfo(id);
		req.getRequestDispatcher("views/manager.html").include(req,resp);	
	}
}
