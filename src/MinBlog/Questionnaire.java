package MinBlog;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Questionnaire
 */
@WebServlet("/questionnaire")
public class Questionnaire extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Questionnaire() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void processRequest(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
    	request.setCharacterEncoding("utf-8");
    	response.setContentType("text/html;charset=utf-8");
    	PrintWriter out =response.getWriter();
    	out.println("<!DOCTYPE HTML PUBLIC '-//w3c//DTD HTML 4.01"+"Transitional//EN");
    	
    	out.println("<html>");
    	out.println("<head>");
    	out.println("<title>Questionnaire</title>");
    	out.println("</head>");
    	out.println("<body>");
    	String page=request.getParameter("page");
    	out.println("<form action ='questionnaire' method='post'>");
    	if(page==null){
    		out.println("问题一 ：<input type='text' name='p1q1'><br>");
    		out.println("问题二：<input type ='text' name='p1q2'><br>");
    		out.println("<input type='submit' name='page' value='下一页'>");
    	}else if("下一页".equals(page)){
    		String q1p1=request.getParameter("p1q1");
    		String p1q2=request.getParameter("p1q2");
    		out.println("问题三<input type='text' name='p2q1'><br>");
    		out.println("<input type ='hidden' name='p1q1' value='"+q1p1+"'>");
    		out.println("<input type ='hidden' name='p1q2' value='"+p1q2+"'>");
    		out.println("<input type='submit' name='page' value='完成'>");
    	}else if("完成".equals(page)){
    		out.println(request.getParameter("p1q1")+"<br>");
    		out.println(request.getParameter("p1q2")+"<br>");
    		out.println(request.getParameter("p2q1")+"<br>");
    	}
    	out.println("</from>");
    	out.println("</body>");
    	out.println("</html>");
    	out.close();
    	
    	
    	
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

}
