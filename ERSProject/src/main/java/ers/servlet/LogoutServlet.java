package ers.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();
		req.getRequestDispatcher("base.html").include(req, resp);
		HttpSession session = req.getSession(false);
		if (session != null){
			session.removeAttribute("username");
			session.removeAttribute("password");
			session.removeAttribute("user_id");
			session.removeAttribute("firstname");
			session.removeAttribute("lastname");
			session.removeAttribute("email");
			session.invalidate();
		}
		
		pw.println("<div id=\"box\">You have successfully logged out.<br>"
				+ "<a href=\"index.html\">Login Again?</a></div>");
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}


}