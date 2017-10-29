package customer;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CustomerDaoImpl;

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
		resp.getWriter().write(cdi.getCustomerUserString(req.getSession(false).getAttribute("username").toString()));
	}
}
