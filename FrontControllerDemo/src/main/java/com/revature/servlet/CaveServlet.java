package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.*;
import javax.servlet.http.*;

import com.revature.dao.CaveDaoImpl;
import com.revature.domain.Cave;
import com.revature.util.RequestHelper;

public class CaveServlet extends HttpServlet {
	
	public CaveServlet() {
		super();
	}

	@Override 
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		CaveDaoImpl cdl= new CaveDaoImpl();
		PrintWriter pw= resp.getWriter();
		for(Cave c: cdl.getCaves())
		{
			pw.println("<p>"+c.getId()+"\t"+c.getName()+"\t"+"Max bears: "+ c.getMaxBears()+"</p>");
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException{

	}
}
