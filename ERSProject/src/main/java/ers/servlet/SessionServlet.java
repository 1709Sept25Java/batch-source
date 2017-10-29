package ers.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionServlet
 */
@WebServlet("/SessionServlet")
public class SessionServlet extends HttpServlet {
       
	private static final long serialVersionUID = 1L;

    public SessionServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if(session!=null){
			response.setContentType("application/json");
			response.getWriter().write("{\"username\":\""+session.getAttribute("username")+"\",");
			response.getWriter().write("\"password\":\""+session.getAttribute("password")+"\",");
			response.getWriter().write("\"user_id\":\""+session.getAttribute("user_id")+"\",");
			response.getWriter().write("\"firstname\":\""+session.getAttribute("firstname")+"\",");
			response.getWriter().write("\"lastname\":\""+session.getAttribute("lastname")+"\",");
			response.getWriter().write("\"email\":\""+session.getAttribute("email")+"\"}");
		} else {
			response.setContentType("application/json");
			response.getWriter().write("{\"username\":null,");
			response.getWriter().write("\"password\":null,");
			response.getWriter().write("\"user_id\":null,");
			response.getWriter().write("\"firstname\":null,");
			response.getWriter().write("\"lastname\":null,");
			response.getWriter().write("\"email\":null}");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}