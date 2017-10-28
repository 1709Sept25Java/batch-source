package com.revature.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.*;

public class MasterServlet extends HttpServlet{

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException{
		HttpSession session = req.getSession();
		if(session != null && session.getAttribute("uid") != null) {
			req.getRequestDispatcher("employee");
		}
		req.getRequestDispatcher("views/index.html").forward(req, resp);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException{
		
	}
}
