package MinBlog;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class search
 */
@WebServlet("/search")
public class search extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public search() {
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
		out.println("<!DOCTYPE HTML PUBLIC '-//W3C//DTD HTML 4.01"+"Transitional//EN'>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>搜索结果</title>");
		out.println("</head>");
		out.print("<body>");
		String start=request.getParameter("start");
		if(start==null){
			start="1";
			
		}
		int count=Integer.parseInt(start);
		int begin=10*count-9;
		int end=10*count;
		out.println("第"+begin+"到"+end+"搜索结果<br>");
		out.println("</ul>");
		for(int i=0;i<=10;i++){
			out.println("<li>搜索结果"+i+"</li>");
		}
		out.println("</ul>");
		for(int i=1;i<=10;i++){
			if(i==count){
				out.println(i);
				continue;
			}
			out.println("<a href='search?start="+i+"'>"+i+"</a>");
		}
		out.println("</body>");
		out.println("</html>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
