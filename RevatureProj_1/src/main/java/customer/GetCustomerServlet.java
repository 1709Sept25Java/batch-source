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
import util.employeeBlob;

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
		
		PrintWriter pw = resp.getWriter();
		//doGet(req, resp);
		String customertable=req.getParameter("customer_data");
		CustomerDaoImpl cdi=new CustomerDaoImpl();
		/*resp.getWriter().write("<div id='dbTitle' style='border-bottom:1pt solid black'> id | user | password | fname | lname | email | rid | </div>");
		for(int i=1; i<cdi.getCustomer().size()+1;i++) {
        resp.getWriter().write("<div id=select"+i+" class='cDataTable' onclick='getSelectedC("+i+")'>"+ cdi.getCustomerIdString(i)+"</div>");
		}*/
		Customer customer=new Customer();
		resp.getWriter().write("<div id='dbTitle' style='border-bottom:1pt solid black'><tr> <td>Id</td>  <td>Username</td> <td>Password</td>  <td>Fname</td>  <td>Lname</td>  <td>Email</td>  <td>RAmount</td> <td>RType</td> <td>RStatus</td> </tr></div>");
		for(int i=1; i<cdi.getCustomer().size();i++) {
		customer.setUserId(i);
		cdi.getCustomer().add(customer);
		
		customer.setUsername(cdi.getCustomerById(i).getUsername());
		customer.setPassword(cdi.getCustomerById(i).getPassword());
		customer.setFirstname(cdi.getCustomerById(i).getFirstname());
		customer.setLastname(cdi.getCustomerById(i).getLastname());
		customer.setEmail(cdi.getCustomerById(i).getEmail());
		
		customer.setR_Amount(cdi.getCustomerAccById(i).getR_Amount());
		customer.setR_Type(cdi.getCustomerAccById(i).getR_Type());
		customer.setR_Status(cdi.getCustomerAccById(i).getR_Status());
		
		resp.getWriter().write("<div><tr contenteditable='true' id=select"+i+" class='cDataTable' onClick='getSelectedC(this.id)'><td>"+ customer.getUserId()+"</td> <td>"+customer.getUsername()+ "</td> <td> "+customer.getPassword()+ "</td> <td> "
				+ customer.getFirstname()+ "</td> <td> "+ customer.getLastname()+ "</td> <td> "+ customer.getEmail());
		
		resp.getWriter().write("<td>"+customer.getR_Amount()+"</td>"+"<td>"+customer.getR_Type()+"</td>"+"<td>"+customer.getR_Status()+"</td> </tr></div>");
		
		}

		String status= req.getParameter("rStatus");
		String getUser= req.getParameter("userSelect");
		String button1= req.getParameter("subad");
		
		if (button1!=null) {
		cdi.updateCustomerReinS(status, getUser);
		}
		String getSelect=req.getParameter("getfield");
		//make hidden field that changes on click
	}

}
