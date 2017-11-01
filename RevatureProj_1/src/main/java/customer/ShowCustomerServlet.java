package customer;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CustomerDaoImpl;
import domain.Customer;

//shows customer their information

public class ShowCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ShowCustomerServlet() {
        super();
    }

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
	}
	

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		HttpSession session = req.getSession();
		
		//gets session for username, and retrieves user information based on that
		CustomerDaoImpl cdi= new CustomerDaoImpl();
		Customer customer=new Customer();
		String sess1=req.getSession(false).getAttribute("username").toString();
		String useracc="<tr>"
		+"<td>"+cdi.getCustomerByUser(sess1).getUsername()+"</td>"
		+"<td>"+cdi.getCustomerByUser(sess1).getPassword()+"</td>"
		+"<td>"+cdi.getCustomerByUser(sess1).getFirstname()+"</td>"
		+"<td>"+cdi.getCustomerByUser(sess1).getLastname()+"</td>"
		+"<td>"+cdi.getCustomerByUser(sess1).getEmail()+"</td></tr>";
		String userheader="<tr><td>Username</td><td>Password</td><td>Firstname</td><td>Lastname</td><td>Email</td></tr>";
		
		String urein="<tr><td>"+cdi.getCustomerAccByUser(sess1).getR_Amount()+"</td>"+
				"<td>"+cdi.getCustomerAccByUser(sess1).getR_Type()+"</td>"
				+"<td>"+cdi.getCustomerAccByUser(sess1).getR_Status()+"</td></tr>";
		String accheader="<tr><td>Amount</td><td>Type</td><td>Status</td>";
		
		resp.getWriter().write(userheader+useracc+"<br></br>"+accheader + urein);
		
		//logout and end session
		String logout= req.getParameter("logout");
		if(logout!=null) {
			session.invalidate();
		}
	}
}
