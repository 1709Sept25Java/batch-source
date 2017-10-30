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
		HttpSession session = req.getSession(true);
		PrintWriter pw = resp.getWriter();
		//pw.println("test");
		req.getRequestDispatcher("../views/employerLogin.html").include(req, resp);
		//servlet save to JSON>angular
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		Boolean clicked=false;
		HttpSession session = req.getSession(true);
		String id1= req.getParameter("selectedUser");
		session.setAttribute("selectedUser", id1);
		
		PrintWriter pw = resp.getWriter();
		//doGet(req, resp);
		String customertable=req.getParameter("customer_data");
		CustomerDaoImpl cdi=new CustomerDaoImpl();
		resp.getWriter().write("<div id='dbTitle' style='border-bottom:1pt solid black'> id | user | password | fname | lname | email | rid | </div>");
		for(int i=1; i<cdi.getCustomer().size()+1;i++) {
        resp.getWriter().write("<div id=select"+i+" class='cDataTable' onclick='getSelectedC("+i+")'>"+ cdi.getCustomerIdString(i)+"</div>");
		}
		cdi.sendBlob("C:\\Users\\jinli\\Desktop\\test1.txt", 1);
		
		if(clicked==true) {
			resp.getWriter().write("");;
		}
	}

}
