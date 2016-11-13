package MinBlog;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Avatar
 */
@WebServlet(urlPatterns={"/avatar"},initParams={@WebInitParam(name="AVATAR_DIR",value="/avatar")})
public class Avatar extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private String AVATAR_DIR;
    /**
     * @see HttpServlet#HttpServlet()
     */
	public void init() throws ServletException{
		AVATAR_DIR=getInitParameter("AVATAR_DIR");
		
	}
    public Avatar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Õ∑œÒœ‘ æ</title>");
		out.println("</head>");
		out.println("<body>");
		for(String avatar:getServletContext().getResourcePaths(AVATAR_DIR)){
			avatar=avatar.replaceFirst("/","");
			out.println("<img src='"+avatar+"'>");
		}
		out.println("</body>");
		out.println("</html>");
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
