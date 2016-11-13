package MinBlog;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login1
 */
@WebServlet("/Login1")
public class Login1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login1() {
        super();
        // TODO Auto-generated constructor stub
    }
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String user=request.getParameter("user");
		String passwd=request.getParameter("passwd");
		if("caterpillar".equals(user)&&"123456".equals(passwd)){
			String login=request.getParameter("login");
			if("auto".equals(login)){
				Cookie cookie=new Cookie("user","caterpillar");
				cookie.setMaxAge(7*24*60*60);
				response.addCookie(cookie);
			}
			request.setAttribute("user",user);
			request.getRequestDispatcher("user").forward(request, response);
		}else{
			response.sendRedirect("login.html");
		}
	}

}
