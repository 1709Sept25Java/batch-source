package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.revature.country.Country;
import com.revature.xmlparse.CountryXmlParse;

public class ProfileServlet extends HttpServlet{

	protected void doGet(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{
		RequestDispatcher rd = req.getRequestDispatcher("base.html");
		
		HttpSession session = req.getSession();
		String username = (String)session.getAttribute("username");
		
		PrintWriter pw = resp.getWriter();
		pw.write("<h1> Welcome "+username+"</h1>");
		
		List<Country> countries = CountryXmlParse.readCountries();
		
		for(Country c : countries) {
			pw.write("<p>Country: "+c.getName()+" Capitol: "+c.getCapitol()+"</p>");
		}
		
	}
	
}
