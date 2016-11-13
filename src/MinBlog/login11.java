package MinBlog;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class login11
 */
@WebServlet(name="login",urlPatterns={"/login11"},
initParams={
	@WebInitParam(name="SUCCESS",value="success"),
	@WebInitParam(name="ERROR",value="error")
}

)
public class login11 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String SUCCESS_VIEW;
	private String ERROR_VIEW;
	@Override
	public void init() throws ServletException{
		SUCCESS_VIEW=getInitParameter("SUCCESS");
		ERROR_VIEW=getInitParameter("ERROR");
	}
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login11() {
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
		response.setContentType("text/html;charset=UTF-8");
		String name=request.getParameter("name");
		String passwd=request.getParameter("passwd");
		if("caterpillar".equals(name)&&"123456".equals(passwd)){
			request.getRequestDispatcher(SUCCESS_VIEW).forward(request, response);
		}else{
			request.getRequestDispatcher(ERROR_VIEW).forward(request, response);
		}
	}

}
