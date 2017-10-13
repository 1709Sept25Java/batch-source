package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.revature.dao.CaveDaoImpl;
import com.revature.domain.Cave;

public class CaveServlet extends HttpServlet{

	public CaveServlet() {
		super();
	}

	@Override
	public void doGet(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{
		CaveDaoImpl cd1 = new CaveDaoImpl();
		PrintWriter pw = resp.getWriter();
		
		for(Cave c : cd1.getCaves()) {
			pw.println("<p> id: "+c.getId()+" name: "+" maxBears: "+c.getMaxBears()+"</p>");
		}
	}
	
	@Override
	public void doPost(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{
		this.doGet(req, resp); //For Now!
	}
	
}
