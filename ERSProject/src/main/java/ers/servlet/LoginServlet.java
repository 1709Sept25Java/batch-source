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

public class LoginServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		PrintWriter pw = resp.getWriter();
		resp.setContentType("text/html");
		req.getRequestDispatcher("index.html").include(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		
		resp.setContentType("text/html");
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		UsersDao ud = new UsersDaoImpl();
		int ur_id = ud.getUserRoleId(username, password);

		if(ur_id == 1) {
			resp.sendRedirect(req.getContextPath() 
					+ "/employee.html");
			session.setAttribute("username", username);
			session.setAttribute("problem", null);
		} else if (ur_id == 2){
			resp.sendRedirect(req.getContextPath() 
					+ "/manager.html");
			session.setAttribute("username", username);
			session.setAttribute("problem", null);
		}else {
			session.setAttribute("problem", "incorrect password");
			resp.sendRedirect("login");
		}
		
	}

}
