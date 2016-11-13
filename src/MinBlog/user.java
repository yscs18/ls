package MinBlog;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class user
 */
@WebServlet("/user")
public class user extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public user() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void processRequest(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
    	response.setContentType("text/html;charset=utf-8");
    	if(request.getAttribute("user")==null){
    		response.sendRedirect("login.html");
    	}
    	PrintWriter out=response.getWriter();
    	out.println("<!DOCTYPE HTML PUBLIC '-//w3c//DTD HTML 4.01"+"Transitional//EN");
    	
    	out.println("<html>");
    	out.println("<head>");
    	out.println("<title>Servlet user</title>");
    	out.println("</head>");
    	out.println("<body>");
    	out.println("<h1>"+request.getAttribute("user")+"ÒÑµÇÂ¼<h1>");
    	out.println("</body>");
    	out.println("</html>");
    	out.close();
    	
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
