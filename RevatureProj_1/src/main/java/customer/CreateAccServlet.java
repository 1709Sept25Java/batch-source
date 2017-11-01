 package customer;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CustomerDaoImpl;
import domain.Customer;

//create acc servlet

public class CreateAccServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CreateAccServlet() {
        super();
    }

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {	          
	    String nUser1=req.getParameter("nUser");  
	    String nPass1=req.getParameter("nPass");
	    String nFname=req.getParameter("nFname");
	    String nLname=req.getParameter("nLname");
	    String nEmail=req.getParameter("nEmail");
	    
	    String userRequired=req.getParameter("userRequired");  
	    String passRequired=req.getParameter("passRequired");
	    
	    CustomerDaoImpl cdi=new CustomerDaoImpl();
	    cdi.createCustomer(nUser1, nPass1, nFname, nLname, nEmail);
		    resp.sendRedirect("views/Login.html");
	    
	    //need to also create a reinbursement acc part
	    
	    //need to verify if username already exists
	    //need to check if username and password is not blank
	}

}
