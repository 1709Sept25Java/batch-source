package com.revature.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.revature.util.RequestHandler;

public class MasterServlet extends HttpServlet{

	public MasterServlet() {
		super();
	}
	
	@Override
	public void doGet(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{
		RequestDispatcher rd = req.getRequestDispatcher("views/index.html");
		rd.forward(req, resp);
	}
	
	@Override
	public void doPost(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{
		
		String destination = RequestHandler.process(req);
		
		resp.sendRedirect(destination);
	}

}
