package com.revature.servlet;
import java.io.*;
import java.rmi.ServerRuntimeException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.dao.*;
import com.revature.domain.Bear;

public class BearServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BearServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServerRuntimeException, IOException {
		PrintWriter pw = response.getWriter();
		try {
			request.getRequestDispatcher("views/Base.html").include(request,response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		BearDaoImpl bdl = new BearDaoImpl();
		
		for (Bear b : bdl.getBears()) {
			pw.println("<p>" + b.toString() + "</p>");
		}
		
		pw.println("<a href=\"home\">Go back!!</a>");
		pw.write("</div></body></html>");

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}