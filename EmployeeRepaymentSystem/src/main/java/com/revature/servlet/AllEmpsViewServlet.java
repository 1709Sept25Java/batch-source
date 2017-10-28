package com.revature.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.*;

public class AllEmpsViewServlet extends HttpServlet{

	protected void doGet(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{
		HttpSession session = req.getSession();
		
		if(session != null && session.getAttribute("uid") != null) {
			req.getRequestDispatcher("views/allEmps.html").forward(req, resp);
		} else {
			resp.sendRedirect("main");
		}
	}
	
}
