package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.revature.util.RequestHandler;

public class ErrorServlet extends HttpServlet{

	@Override
	public void doGet(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{
		PrintWriter pw = resp.getWriter();
		req.getRequestDispatcher("views/Base.html").include(req, resp);;
		pw.println("<h1 class=\"box\">NO</h1>");
		ServletConfig config = this.getServletConfig();
		pw.println(config.getInitParameter("message")+"</div>");
		pw.println("<a href=\"home\">Go Back</a>");
	}
	
	@Override
	public void doPost(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{
		
		this.doGet(req, resp);
	}
	
}
