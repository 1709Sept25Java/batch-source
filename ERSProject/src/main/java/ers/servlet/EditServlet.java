package ers.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import ers.dao.UsersDao;
import ers.dao.UsersDaoImpl;
import ers.domain.Users;

public class EditServlet extends HttpServlet{

	@Override 
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		resp.setContentType("text/html");
		req.getRequestDispatcher("editInfo.html").include(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)throws ServletException,IOException{
		
		HttpSession session = req.getSession();
		
		resp.setContentType("text/html");
		
		String password = req.getParameter("password").trim();
		String firstname = req.getParameter("firstname").trim();
		String lastname = req.getParameter("lastname").trim();
		String email = req.getParameter("email").trim();
		String username = (String) session.getAttribute("username");
		
		UsersDao ud = new UsersDaoImpl();
		
		if(!password.equals("")){
			session.setAttribute("password", password);
			ud.updateUsers(username, "U_PASSWORD", password);
		}
		if(!firstname.equals("")) {
			session.setAttribute("firstname", firstname);
			ud.updateUsers(username, "U_FIRSTNAME", firstname);
		}
		if(!lastname.equals("")) {
			session.setAttribute("lastname", lastname);
			ud.updateUsers(username, "U_LASTNAME", lastname);
		}
		if(!email.equals("")) {
			session.setAttribute("email", email);
			ud.updateUsers(username, "U_EMAIL", email);
		}
		resp.sendRedirect(req.getContextPath() + "/info.html");
	}
}
