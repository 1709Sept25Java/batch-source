package customer;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CustomerDaoImpl;

//employee view

public class GetCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public GetCustomerServlet() {
        super();
    }

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		HttpSession session = req.getSession();
		PrintWriter pw = resp.getWriter();
		//pw.println("test");
		req.getRequestDispatcher("../views/employerLogin.html").include(req, resp);
		//servlet save to JSON>angular
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		HttpSession session = req.getSession();
		PrintWriter pw = resp.getWriter();
		//doGet(req, resp);
		String customertable=req.getParameter("customer_data");
		CustomerDaoImpl cdi=new CustomerDaoImpl();
		for(int i=1; i<cdi.getCustomer().size()+1;i++) {
        resp.getWriter().write("<tr> "+ cdi.getCustomerIdString(i) + "<br></br> </tr>");
		}
	}

}
