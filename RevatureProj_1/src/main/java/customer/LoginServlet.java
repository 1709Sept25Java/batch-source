package customer;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CustomerDao;
import dao.CustomerDaoImpl;
import domain.Customer;
import driver.ManageConnection;
import util.Login;
//redirects logins and creates session objects

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LoginServlet() {
        super();
    }
    
    @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
    	HttpSession session = req.getSession();
		PrintWriter pw = resp.getWriter();
		//pw.println("test");
		req.getRequestDispatcher("../views/Login.html").include(req, resp);
	}

    @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException { 
    		HttpSession session = req.getSession(true);
    		
    	    PrintWriter pw = resp.getWriter();  
    	          
    	    String username=req.getParameter("user1");  
    	    String password=req.getParameter("pass1");
    	    
    	    if(username.equals("admin") & password.equals("pw")) {
    	    	resp.sendRedirect("views/employerLogin.html");
    	    	
    	    	session.setAttribute("username", username);
    			session.setAttribute("problem", null);
    	    	//pw.println("Admin login!");
    	    }
    	   
    	    else if(Login.credentials(username, password)){  
    	    	resp.sendRedirect("views/LoginSuccess.html");

    	    	session.setAttribute("username", username);
    			session.setAttribute("problem", null);
    	    	//pw.println("Login success!");
    			
    			//CustomerDaoImpl cdi=new CustomerDaoImpl();
    	    }  
    	    
    	    else{ 
    	        resp.sendRedirect("views/Login.html"); 
    	        //pw.print("<p> Incorrect username or password! with the username "+username+"</p>");
    	    }        
    	    pw.close();  
	}

}
