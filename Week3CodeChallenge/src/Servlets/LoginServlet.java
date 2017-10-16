package Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.*;

public class LoginServlet extends HttpServlet{
	
	public LoginServlet() {
		super();
	}
	
	private static final long serialVersionUID = 3157962322160824370L;
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		PrintWriter pw = resp.getWriter();
		
		if(username.equals("HelloWorld") && password.equals("login123")) {
			pw.write("<h2>Login Successful</h2> <br> <h1>Welcome "+username);
			pw.write("<h1>");
		} else {
			pw.write("<h2>Login Unsuccessful, Try Again</h2> <a href=\"Login\">Return to Login</a>");
		}
		
		
		
	}
	

}
