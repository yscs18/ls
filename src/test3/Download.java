package test3;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Download
 */
@WebServlet("/Download")
public class Download extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Download() {
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
		String passwd=request.getParameter("passwd");
		if("123456".equals(passwd)){
			response.setContentType("application/pdf");
			InputStream in=getServletContext().getResourceAsStream("/WEB-INF/jdbc.pdf");
			OutputStream out=response.getOutputStream();
			writeBytes(in,out);
		}
	}

	private void writeBytes(InputStream in, OutputStream out)throws IOException {
		// TODO Auto-generated method stub
		byte[] buffer=new byte[1024];
		int length=-1;
		while((length=in.read(buffer))!=-1){
			out.write(buffer,0,length);
		}
		in.close();
		out.close();
	}

}
