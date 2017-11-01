package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.pojo.User;
import com.revature.pojo.UserRoles;
import com.revaturedao.UserBusinessLogic;
import com.revaturedao.UserDao;

public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		while (session != null) {
			String username = (String) session.getAttribute("username");
			String password = (String) session.getAttribute("password");
			System.out.println(username);

			UserDao userDao = new UserDao();
			ArrayList<User> usersArrayList = new ArrayList<User>();

			if (UserBusinessLogic.adminUser(username, password) == true) {

				try {
					usersArrayList = userDao.getEmployee();
					out.println("<table border=\"1\">");
					out.println("<tr>");
					for (int i = 0; i < usersArrayList.size(); i++) {
						if (i > 0 && i % 4 != 0) {
							out.println("</tr><tr>");
						}
						out.println("<td>" + usersArrayList.get(i) + "</td>");
					}
					out.println("</table>");
					out.print("</div>");
					out.println("</body>");
					out.println("</html>");
					request.getRequestDispatcher("/admin.html").include(request, response);
				} catch (ClassNotFoundException | SQLException e) {

					e.printStackTrace();
				}

			} else {
				request.getRequestDispatcher("/Login.html").include(request, response);

				out.println("Invalid username or password");
			}
			break;
		}

	}
}
