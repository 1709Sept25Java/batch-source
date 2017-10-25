package customer;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


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
		pw.println("test");
    	//resp.setContentType("text/html");
		//req.getRequestDispatcher("Login.html").include(req, resp);
	}

    @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException { 
    	    PrintWriter pw = resp.getWriter();  
    	          
    	    String username=req.getParameter("user1");  
    	    String password=req.getParameter("pass1");  
    	          
    	    if(Login.credentials(username, password)){  
    	        RequestDispatcher rd=req.getRequestDispatcher("LoginServlet");  
    	        rd.forward(req,resp);  
    	    }  
    	    else{  
    	        pw.print("Incorrect username or password!");  
    	        RequestDispatcher rd=req.getRequestDispatcher("Logout.html");  
    	        rd.include(req,resp);  
    	    }        
    	    pw.close();  
	}

}
