package test3;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class uploaServlet
 */
@MultipartConfig
@WebServlet("/uploaServlet")
public class uploaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public uploaServlet() {
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
		Part part=request.getPart("photo");
		String filename=getFilename(part);
		writeTo(filename,part);
	}
	private String getFilename(Part part){
		String header=part.getHeader("Content-Disposition");
		String filename=header.substring(header.indexOf("filename=\"")+10,header.lastIndexOf("\""));
		return filename;
	}
	private void writeTo(String filename,Part part)throws IOException,FileNotFoundException{
		InputStream in = part.getInputStream();
		OutputStream out=new FileOutputStream("c:/workspace/"+filename);
		byte[] buffer=new byte[2028];
		int length=-1;
		while((length=in.read(buffer))!=-1){
			out.write(buffer, 0, length);
		}
		in.close();
		out.close();
	}
	

}
