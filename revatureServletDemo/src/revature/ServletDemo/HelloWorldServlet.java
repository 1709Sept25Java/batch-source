package revature.ServletDemo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloWorldServlet extends HttpServlet {

	public HelloWorldServlet() {
		super();
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		PrintWriter pw = resp.getWriter();
		pw.write("Panda Login" + "<a href=\"testRedirect.html\">");
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		PrintWriter pw = resp.getWriter();
		String name= req.getParameter("name");
		String email= req.getParameter("email");
		String password= req.getParameter("password");
		
		
		pw.write("Registered!"
				+ "\nName: "+name
				+ "\nEmail: "+email
				+ "\nPassword: "+password);
		
		resp.sendRedirect("testRedirect.html");
	}
}
