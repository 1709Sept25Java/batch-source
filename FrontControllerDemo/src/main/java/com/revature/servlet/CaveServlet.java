package com.revature.servlet;

import javax.servlet.http.*;
import javax.servlet.*;

import java.io.*;

import com.revature.dao.*;
import com.revature.domain.Cave;

public class CaveServlet extends HttpServlet {
	public CaveServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		request.getRequestDispatcher("views/Base.html").include(request,response);
		CaveDaoImpl cdl = new CaveDaoImpl();
		for (Cave c : cdl.getCaves()) {
			pw.println("<p>id: " + c.getId() + "\t name: " + c.getName() + "\t max bears: " + c.getMaxBears() + "</p>");
		}

		/*
		 * pw.println("<p>What am I?</p>"); ServletConfig config =
		 * getServletConfig();
		 * pw.println("<p>"+config.getInitParameter("whatAmI")+"</p>");
		 * pw.println("<p>Where are we?</p>");
		 * pw.println("<p>"+config.getServletContext().getInitParameter(
		 * "whereAreWe")+"</p>");
		 */
		pw.println("<a href=\"home\">Go back!!</a>");
		pw.write("</div></body></html>");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}
}