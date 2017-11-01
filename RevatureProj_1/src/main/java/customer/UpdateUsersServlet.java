package customer;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CustomerDaoImpl;
import domain.Customer;

//updates user
public class UpdateUsersServlet extends HttpServlet {
       
    public UpdateUsersServlet() {
        super();
    }
    
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		Customer customer=new Customer();
		CustomerDaoImpl cdi= new CustomerDaoImpl();
		
		String status="pending";
		String sess1=req.getSession(false).getAttribute("username").toString();
		int subR=Integer.parseInt(req.getParameter("rAmount"));

			cdi.updateCustomerReinA(subR, sess1);
			cdi.updateCustomerReinS(status, sess1);
			
			resp.sendRedirect("views/LoginSuccess.html");
			//System.out.println(subR + sess1 + status);
	}

}
