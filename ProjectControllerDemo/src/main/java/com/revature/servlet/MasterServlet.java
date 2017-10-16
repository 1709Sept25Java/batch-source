package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.revature.util.RequestHelper;

public class MasterServlet extends HttpServlet{
	
	public MasterServlet() {
		super();
		
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		RequestDispatcher rd = req.getRequestDispatcher("views/index.html");
		rd.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		//call upon a ResquestHelper for routing
		//send a redirect to the desired servlet
		/*String destination = req.getParameter("destination");
		PrintWriter pw = resp.getWriter();
		pw.write("i want to go: "+ destination);*/
		
		String destination = RequestHelper.process(req);
		resp.sendRedirect(destination);
	}
}
