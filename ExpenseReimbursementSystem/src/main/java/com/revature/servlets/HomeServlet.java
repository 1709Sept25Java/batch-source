package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.dao.EmployeeDaoImpl;
import com.revature.domain.Employee;

/**
 * Servlet implementation class HomeServlet
 */
@WebServlet("/HomeServlet")
public class HomeServlet extends HttpServlet {

       
    /**
	 * 
	 */
	private static final long serialVersionUID = -3129893435078072004L;

	/**
     * @see HttpServlet#HttpServlet()
     */
    public HomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String user = (String) session.getAttribute("Username");
		PrintWriter pw = response.getWriter();
		String fname = "name placeholder";
		String email = "email placeholder";
		try {
			Employee e = new Employee();
			e = EmployeeDaoImpl.getEmployee(user, e);
			fname = e.getEmployeeFirst();
			email = e.getEmployeeEmail();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		pw.write("{\"name\": \""+fname+"\",\"email\": \""+email+"\"}");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
