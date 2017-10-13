package revature.ServletDemo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.*;

public class CalculatorServlet extends HttpServlet {

	private static final long serialVersionUID = -756208604967516279L;
	
	public CalculatorServlet(){
		super();
	}
	
	@Override 
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		PrintWriter pw = resp.getWriter();
		pw.write("<p>The calculator page is </p> <br> <a href=\"Calculator.html\">here</a>");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException{
		//Obtain request parameters
		String n1= req.getParameter("n1");
		String n2= req.getParameter("n2"); 
		String op= req.getParameter("op");
		String ans= "";
		//Calculate answer
		try {
			Double first= Double.parseDouble(n1);
			Double second= Double.parseDouble(n2);
			
		
		switch(op) {
		case "add":ans= " "+ (first+second);
			break;
		case "subtract":ans= " "+ (first-second);
			break;
		case "multiply":ans= " "+ (first*second);
			break;
		case "divide":ans= " "+ (first/second);
			break;
			
		default: ans="invalid number or operation!";
				}
		}
		catch(Exception e)
		{
			ans="invalid number!";
			e.printStackTrace();
		}
		PrintWriter pw = resp.getWriter();
		pw.write("<p>The answer is: "+ans+"</p>");
		pw.write("<p><a href=\"Calculator.html\">MORE NUMBER PLEASE</a></p>");
	}

}